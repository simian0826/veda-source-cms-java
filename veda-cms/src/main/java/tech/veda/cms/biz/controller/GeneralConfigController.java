package tech.veda.cms.biz.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tech.veda.cms.biz.common.Result;
import tech.veda.cms.biz.service.IGeneralConfigService;
import tech.veda.cms.biz.service.dto.AboutUsDTO;
import tech.veda.cms.biz.service.dto.BasicInfoDTO;
import tech.veda.cms.biz.service.dto.HomePageDTO;
import tech.veda.cms.biz.service.vo.AboutUsVO;
import tech.veda.cms.biz.service.vo.HomePageVO;
import tech.veda.cms.sys.service.SessionService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Bruno
 * @since 2024-06-21
 */
@RestController
@RequestMapping("/generalConfig")
public class GeneralConfigController {

  private final SessionService sessionService;

  public GeneralConfigController(SessionService sessionService) {
    this.sessionService = sessionService;
  }

  @Autowired
  IGeneralConfigService generalConfigService;



  @PostMapping("/updateHomePage")
  public Result<Boolean> updateHomePage(@RequestBody HomePageDTO homePageDTO){
    return Result.succ(generalConfigService.updateHomePage(homePageDTO));
  }

    @GetMapping("/findHomePage")
  public Result<HomePageVO> findHomePage() throws JsonProcessingException {
    return Result.succ(generalConfigService.findHomePage());
  }

  @GetMapping("/findAboutUsPage")
  public Result<AboutUsVO> updateAboutUsPage() {
    return Result.succ(generalConfigService.findAboutUsPage());
  }

  @PostMapping("/updateAboutUsPage")
  public Result<Boolean> updateAboutUsPage(@RequestBody AboutUsDTO aboutUsDTO){
    return Result.succ(generalConfigService.updateAboutUsPage(aboutUsDTO));
  }

  @GetMapping("/findBasicInfo")
  public Result<AboutUsVO> updateBasicInfo() {
    return Result.succ(generalConfigService.findBasicInfo());
  }

  @PostMapping("/updateBasicInfo")
  public Result<Boolean> updateBasicInfo(@RequestBody @Validated BasicInfoDTO basicInfoDTO){
    return Result.succ(generalConfigService.updateBasicInfo(basicInfoDTO));
  }


}
