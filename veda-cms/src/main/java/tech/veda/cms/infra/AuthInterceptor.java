package tech.veda.cms.infra;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import tech.veda.cms.common.CommonResultStatus;
import tech.veda.cms.common.Constants;
import tech.veda.cms.common.authz.PermissionHelper;
import tech.veda.cms.common.authz.RequiresPermissions;
import tech.veda.cms.sys.service.SessionService;
import tech.veda.cms.sys.service.dto.UserinfoDTO;
import tech.veda.cms.common.BusinessException;
import tech.veda.cms.common.SessionItemHolder;

/**
 * @author Bruno
 */
public class AuthInterceptor implements HandlerInterceptor {

  private final SessionService sessionService;
  private final Logger log = LoggerFactory.getLogger(getClass());

  public AuthInterceptor(SessionService sessionService) {
    this.sessionService = sessionService;
  }

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
      if (request.getHeader("Authorization") == null) {
      log.warn("Request uri {} {} is unauthorized", request.getMethod(), request.getRequestURI());
      throw new BusinessException(CommonResultStatus.UNAUTHORIZED);
    }
    String token = request.getHeader("Authorization").replace("Bearer", "").trim();
    if (!sessionService.isLogin(token)) {
      throw new BusinessException(CommonResultStatus.UNAUTHORIZED, "未登录");
    }
    UserinfoDTO loginUserInfo = sessionService.getLoginUserInfo(token);
    if (handler instanceof HandlerMethod handlerMethod) {
      RequiresPermissions requiresPermissions = handlerMethod.getMethodAnnotation(RequiresPermissions.class);
      if (requiresPermissions != null) {
        if (!PermissionHelper.isPermitted(loginUserInfo.permissions(), requiresPermissions.value(), requiresPermissions.logical())) {
          throw new BusinessException(CommonResultStatus.FORBIDDEN);
        }
      }
    }
    SessionItemHolder.setItem(Constants.SESSION_CURRENT_USER, loginUserInfo);
    return true;
  }
}
