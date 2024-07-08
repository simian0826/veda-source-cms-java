package tech.vedaSource.cms.biz.service;

import tech.vedaSource.cms.biz.entity.HeroSection;
import com.baomidou.mybatisplus.extension.service.IService;
import tech.vedaSource.cms.biz.service.dto.HeroSectionDTO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Bruno
 * @since 2024-06-21
 */
public interface IHeroSectionService extends IService<HeroSection> {

  List<HeroSection> findHeroSections();

  Boolean updateHeroSections(List<HeroSection> heroSections);
}
