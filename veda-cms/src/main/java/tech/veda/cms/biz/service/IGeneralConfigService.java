package tech.veda.cms.biz.service;

import tech.veda.cms.biz.service.dto.HomePageDTO;
import tech.veda.cms.biz.entity.GeneralConfig;
import com.baomidou.mybatisplus.extension.service.IService;

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
