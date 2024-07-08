package tech.vedaSource.cms.infra.service;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import tech.vedaSource.cms.common.CommonResultStatus;
import tech.vedaSource.cms.common.Constants;
import tech.vedaSource.cms.common.DomainEventPublisher;
import tech.vedaSource.cms.sys.event.UserLoggedIn;
import tech.vedaSource.cms.sys.event.UserLoggedOut;
import tech.vedaSource.cms.sys.exception.UserException;
import tech.vedaSource.cms.sys.model.User;
import tech.vedaSource.cms.sys.model.UserCredential;
import tech.vedaSource.cms.sys.repository.UserCredentialRepository;
import tech.vedaSource.cms.sys.service.SessionService;
import tech.vedaSource.cms.sys.service.dto.UserinfoDTO;
import tech.vedaSource.cms.common.SessionItemHolder;

import java.util.UUID;

/**
 * @author Bruno
 */
@Service
public class DefaultSessionService implements SessionService {

  private final UserCredentialRepository userCredentialRepository;

  private final SessionManager sessionManager;

  public DefaultSessionService(UserCredentialRepository userCredentialRepository, SessionManager sessionManager) {
    this.userCredentialRepository = userCredentialRepository;
    this.sessionManager = sessionManager;
  }


  @Override
  public UserinfoDTO login(String username, String password) {
    UserCredential credential = userCredentialRepository.findCredential(username, UserCredential.IdentityType.PASSWORD)
      .orElseThrow(() -> new UserException(CommonResultStatus.UNAUTHORIZED, "密码不正确"));
    if (credential.doCredentialMatch(password)) {
      User user = credential.getUser();
      if (user.isLocked()) {
        throw new UserException(CommonResultStatus.UNAUTHORIZED, "用户已经停用，请与管理员联系");
      }
      String token = UUID.randomUUID().toString().replace("-", "");
      UserinfoDTO userinfo = new UserinfoDTO(token, user.getId(), user.getUsername(), user.getAvatar(), new UserinfoDTO.Credential(credential.getIdentifier(), credential.getIdentityType()), user.findPermissions());
      sessionManager.store(token, credential, userinfo);
      SessionItemHolder.setItem(Constants.SESSION_CURRENT_USER, userinfo);
      DomainEventPublisher.instance().publish(new UserLoggedIn(userinfo, getClientIP()));
      return userinfo;
    } else {
      throw new UserException(CommonResultStatus.UNAUTHORIZED, "密码不正确");
    }
  }

  public String getClientIP() {
    HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    String ipAddress = request.getHeader("X-FORWARDED-FOR");
    if (ipAddress == null) {
      ipAddress = request.getRemoteAddr();
    }
    return ipAddress;
  }

  @Override
  public void logout(String token) {
    UserinfoDTO userinfo = (UserinfoDTO) sessionManager.get(token);
    sessionManager.invalidate(token);
    DomainEventPublisher.instance().publish(new UserLoggedOut(userinfo));
  }

  @Override
  public boolean isLogin(String token) {
    return sessionManager.get(token) != null;
  }

  @Override
  public UserinfoDTO getLoginUserInfo(String token) {
    return (UserinfoDTO) sessionManager.get(token);
  }

  @Override
  public void refresh() {
    sessionManager.refresh();
  }
}
