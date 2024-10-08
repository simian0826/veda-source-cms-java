package tech.veda.cms.infra.service;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import tech.veda.cms.biz.common.Result;
import tech.veda.cms.sys.event.UserLoggedIn;
import tech.veda.cms.sys.event.UserLoggedOut;
import tech.veda.cms.sys.repository.UserCredentialRepository;
import tech.veda.cms.common.CommonResultStatus;
import tech.veda.cms.common.Constants;
import tech.veda.cms.common.DomainEventPublisher;
import tech.veda.cms.sys.exception.UserException;
import tech.veda.cms.sys.model.User;
import tech.veda.cms.sys.model.UserCredential;
import tech.veda.cms.sys.service.SessionService;
import tech.veda.cms.sys.service.dto.UserinfoDTO;
import tech.veda.cms.common.SessionItemHolder;

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
  public Result<UserinfoDTO> login(String username, String password) {
    UserCredential credential = userCredentialRepository.findCredential(username, UserCredential.IdentityType.PASSWORD)
      .orElseThrow(() -> new UserException(CommonResultStatus.UNAUTHORIZED, "Username or password is incorrect"));
    if (credential.doCredentialMatch(password)) {
      User user = credential.getUser();
      if (user.isLocked()) {
        throw new UserException(CommonResultStatus.UNAUTHORIZED, "This user does not exist");
      }
      String token = UUID.randomUUID().toString().replace("-", "");
      UserinfoDTO userinfo = new UserinfoDTO(token, user.getId(), user.getUsername(), user.getAvatar(), new UserinfoDTO.Credential(credential.getIdentifier(), credential.getIdentityType()), user.findPermissions());
      sessionManager.store(token, credential, userinfo);
      SessionItemHolder.setItem(Constants.SESSION_CURRENT_USER, userinfo);
      DomainEventPublisher.instance().publish(new UserLoggedIn(userinfo, getClientIP()));
      return Result.succ(userinfo);
    } else {
      return Result.fail("Username or password is incorrect!");

//      throw new UserException(CommonResultStatus.UNAUTHORIZED, "Username or password is incorrect");
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

  @Override
  public Result<Boolean> changePassword(String username, String oldPassword, String newPassword) {
    UserCredential credential = userCredentialRepository.findCredential(username, UserCredential.IdentityType.PASSWORD)
      .orElseThrow(() -> new UserException(CommonResultStatus.UNAUTHORIZED, "Password is incorrect"));
    if (!credential.doCredentialMatch(oldPassword)) {
      return Result.fail("Password is incorrect");

    }
    String newPasswordEncrypt = credential.passwordEncrypt(newPassword);
    int id = userCredentialRepository.changePassword(username, newPasswordEncrypt);
    if(id == 1){
      return Result.succ(true);
    }else {
      return Result.fail("Change password failed");
    }
  }
}
