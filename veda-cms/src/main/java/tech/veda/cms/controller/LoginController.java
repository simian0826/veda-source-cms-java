package tech.veda.cms.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tech.veda.cms.biz.common.Result;
import tech.veda.cms.sys.service.SessionService;
import tech.veda.cms.sys.service.dto.UserinfoDTO;

/**
 * @author Bruno
 */
@RestController
public class LoginController {

  private final SessionService sessionService;

  public LoginController(SessionService sessionService) {
    this.sessionService = sessionService;
  }

  @PostMapping("/login")
  public Result<UserinfoDTO> login(@RequestBody @Valid LoginRequest request) {
    return sessionService.login(request.username(), request.password());
  }

  @SecurityRequirement(name = "bearerAuth")
  @PostMapping("/logout")
  public ResponseEntity<Void> logout(HttpServletRequest request) {
    String token = request.getHeader("Authorization").replace("Bearer", "").trim();
    sessionService.logout(token);
    return ResponseEntity.ok().build();
  }

  @SecurityRequirement(name = "bearerAuth")
  @GetMapping("/userinfo")
  public Result<UserinfoDTO> userInfo(HttpServletRequest request) {
    String token = request.getHeader("Authorization").replace("Bearer", "").trim();
    return Result.succ(sessionService.getLoginUserInfo(token));
  }

  record LoginRequest(@NotBlank String username, @NotBlank String password) {
  }



  @PostMapping("/changePassword")
  public Result<Boolean> changePassword(HttpServletRequest request, @RequestBody @Valid ChangePasswordParams params) {

    String token = request.getHeader("Authorization").replace("Bearer", "").trim();
    UserinfoDTO userinfo = sessionService.getLoginUserInfo(token);
    return sessionService.changePassword(userinfo.username(), params.oldPassword, params.newPassword);
  }

  record ChangePasswordParams(@NotBlank String oldPassword, @NotBlank String newPassword) {
  }




}
