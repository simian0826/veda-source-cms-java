package tech.veda.cms.biz.controller;

import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
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
