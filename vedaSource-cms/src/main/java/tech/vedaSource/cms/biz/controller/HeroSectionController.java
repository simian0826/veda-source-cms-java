package tech.vedaSource.cms.biz.controller;

import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import tech.vedaSource.cms.biz.entity.HeroSection;
import tech.vedaSource.cms.biz.service.IHeroSectionService;
import tech.vedaSource.cms.biz.service.dto.HeroSectionDTO;
import tech.vedaSource.cms.biz.service.dto.ProductListRequestDTO;
import tech.vedaSource.cms.biz.service.impl.HeroSectionServiceImpl;
import tech.vedaSource.cms.biz.service.vo.ProductVO;
import tech.vedaSource.cms.sys.service.dto.PageDTO;

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
@RequestMapping("/heroSection")
public class HeroSectionController {

  @Autowired
  IHeroSectionService heroSectionService;

  @GetMapping("/findHeroSections")
  public ResponseEntity<List<HeroSection>> findHeroSections() {

    return ResponseEntity.ok(heroSectionService.findHeroSections());
  }

  @PostMapping("/update")
  public ResponseEntity<Boolean> updateHeroSections(@RequestBody @NotNull List<HeroSection> heroSections) {

    return ResponseEntity.ok(heroSectionService.updateHeroSections(heroSections));
  }

}
