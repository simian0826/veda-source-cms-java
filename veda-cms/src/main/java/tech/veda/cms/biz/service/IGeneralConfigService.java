package tech.veda.cms.biz.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import tech.veda.cms.biz.common.Result;
import tech.veda.cms.biz.service.dto.AboutUsDTO;
import tech.veda.cms.biz.service.dto.BasicInfoDTO;
import tech.veda.cms.biz.service.dto.HomePageDTO;
import tech.veda.cms.biz.entity.GeneralConfig;
import com.baomidou.mybatisplus.extension.service.IService;
import tech.veda.cms.biz.service.vo.AboutUsVO;
import tech.veda.cms.biz.service.vo.BasicInfoVO;
import tech.veda.cms.biz.service.vo.HomePageVO;

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

  HomePageVO findHomePage() throws JsonProcessingException;

  AboutUsVO findAboutUsPage();

  Boolean updateAboutUsPage(AboutUsDTO aboutUsDTO);

  Boolean updateBasicInfo(BasicInfoDTO basicInfoDTO);

  BasicInfoVO findBasicInfo();

}
