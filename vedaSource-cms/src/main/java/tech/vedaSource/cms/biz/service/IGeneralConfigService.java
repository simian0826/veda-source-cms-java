package tech.vedaSource.cms.biz.service;

import tech.vedaSource.cms.biz.entity.GeneralConfig;
import com.baomidou.mybatisplus.extension.service.IService;
import tech.vedaSource.cms.biz.entity.HeroSection;
import tech.vedaSource.cms.biz.service.dto.HomePageDTO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Bruno
 * @since 2024-06-21
 */
public interface IGeneralConfigService extends IService<GeneralConfig> {

  Boolean updateHomePage(HomePageDTO homePageDTO);
}
