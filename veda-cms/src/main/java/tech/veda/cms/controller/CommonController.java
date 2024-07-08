package tech.veda.cms.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.veda.cms.VedaSourceCMSProperties;

import java.util.List;

/**
 * 通用功能控制器，声明全局枚举，数据字典等
 *
 * @author Bruno
 */
@SecurityRequirement(name = "bearerAuth")
@RestController
@RequestMapping("/common")
public class CommonController {

  private final VedaSourceCMSProperties admin3Properties;

  public CommonController(VedaSourceCMSProperties admin3Properties) {
    this.admin3Properties = admin3Properties;
  }

  @GetMapping("/event-types")
  public ResponseEntity<List<TypeInfo>> findEventTypes() {
    List<TypeInfo> typeInfos = admin3Properties.getEvents().entrySet().stream()
      .map(entry -> new TypeInfo(entry.getValue().getText(), entry.getKey()))
      .toList();
    return ResponseEntity.ok(typeInfos);
  }

  record TypeInfo(String label, String value) {
  }


}
