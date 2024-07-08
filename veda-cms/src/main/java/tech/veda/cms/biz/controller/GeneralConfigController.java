package tech.veda.cms.biz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import tech.veda.cms.biz.service.dto.HomePageDTO;
import tech.veda.cms.biz.service.IGeneralConfigService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Bruno
 * @since 2024-06-21
 */
@Controller
@RequestMapping("/generalConfig")
public class GeneralConfigController {

  @Autowired
  IGeneralConfigService generalConfigService;


  @PostMapping("/updateHomePage")
  public ResponseEntity<Boolean> updateHomePage(@RequestBody HomePageDTO homePageDTO){

    return ResponseEntity.ok(generalConfigService.updateHomePage(homePageDTO));
  }
}
