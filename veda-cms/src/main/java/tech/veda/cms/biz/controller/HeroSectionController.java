package tech.veda.cms.biz.controller;

import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.veda.cms.biz.common.Result;
import tech.veda.cms.biz.entity.HeroSection;
import tech.veda.cms.biz.service.IHeroSectionService;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Bruno
 * @since 2024-06-21
 */
@RestController
@RequestMapping("/heroSection")
public class HeroSectionController {

  @Autowired
  IHeroSectionService heroSectionService;

  @GetMapping("/findHeroSections")
  public Result<List<HeroSection>> findHeroSections() {

    return Result.succ(heroSectionService.findHeroSections());
  }

  @PostMapping("/update")
  public Result<Boolean> updateHeroSections(@RequestBody @Validated List<HeroSection> heroSections) {

    return Result.succ(heroSectionService.updateHeroSections(heroSections));
  }

}
