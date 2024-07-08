package tech.vedaSource.cms.sys.service;

import org.springframework.stereotype.Service;
import tech.vedaSource.cms.sys.service.dto.UserinfoDTO;

/**
 * @author Bruno
 */
@Service
public interface SessionService {

  UserinfoDTO login(String username, String password);

  void logout(String token);

  boolean isLogin(String token);

  UserinfoDTO getLoginUserInfo(String token);

  void refresh();

}
