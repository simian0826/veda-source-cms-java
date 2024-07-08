package tech.vedaSource.cms.biz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import tech.vedaSource.cms.biz.entity.HeroSection;
import tech.vedaSource.cms.biz.service.IGeneralConfigService;
import tech.vedaSource.cms.biz.service.dto.HomePageDTO;

import java.util.List;

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
