package tech.veda.cms.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.veda.cms.common.authz.RequiresPermissions;
import tech.veda.cms.sys.service.LogService;
import tech.veda.cms.sys.service.dto.LogDTO;
import tech.veda.cms.sys.service.dto.PageDTO;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @author Bruno
 */
@SecurityRequirement(name = "bearerAuth")
@RestController
@RequestMapping("/logs")
public class LogController {

  private final LogService logService;

  public LogController(LogService logService) {
    this.logService = logService;
  }

  @GetMapping
  @RequiresPermissions("log:view")
  public ResponseEntity<PageDTO<LogDTO>> findLogs(Pageable pageable, String typeNames) {
    Set<String> typeNameSet = ofNullable(typeNames).stream()
      .flatMap(t -> Arrays.stream(t.split(",")))
      .collect(Collectors.toSet());
    return ResponseEntity.ok(logService.findLogs(typeNameSet, pageable));
  }


  /**
   * 清空日志
   *
   * @return
   */
  @DeleteMapping
  @RequiresPermissions("log:clean")
  public ResponseEntity<Void> cleanLogs() {
    logService.cleanLogs();
    return ResponseEntity.noContent().build();
  }

}
