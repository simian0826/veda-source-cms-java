package tech.veda.cms.sys.service;

import org.springframework.stereotype.Service;
import tech.veda.cms.biz.common.Result;
import tech.veda.cms.controller.LoginController;
import tech.veda.cms.sys.service.dto.UserinfoDTO;

/**
 * @author Bruno
 */
@Service
public interface SessionService {

  Result<UserinfoDTO> login(String username, String password);

  void logout(String token);

  boolean isLogin(String token);

  UserinfoDTO getLoginUserInfo(String token);

  void refresh();

  Result<Boolean> changePassword(String username, String oldPassword, String newPassword);



}
