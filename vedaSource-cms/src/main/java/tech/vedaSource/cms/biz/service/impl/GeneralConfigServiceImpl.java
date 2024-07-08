package tech.vedaSource.cms.biz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import tech.vedaSource.cms.biz.common.GeneralConfigType;
import tech.vedaSource.cms.biz.entity.GeneralConfig;
import tech.vedaSource.cms.biz.exception.GeneralConfigException;
import tech.vedaSource.cms.biz.mapper.GeneralConfigMapper;
import tech.vedaSource.cms.biz.service.IGeneralConfigService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import tech.vedaSource.cms.biz.service.dto.HomePageDTO;
import tech.vedaSource.cms.common.CommonResultStatus;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Bruno
 * @since 2024-06-21
 */
@Service
public class GeneralConfigServiceImpl extends ServiceImpl<GeneralConfigMapper, GeneralConfig> implements IGeneralConfigService {

  @Override
  public Boolean updateHomePage(HomePageDTO homePageDTO) {

    if(homePageDTO.getIntroductionItems().size() != 3){
      throw new GeneralConfigException(CommonResultStatus.SERVER_ERROR, "Introduction item size must be 3");
    }

    if(homePageDTO.getProcessItems().size() <= 0 || homePageDTO.getProcessItems().size() > 5){
      throw new GeneralConfigException(CommonResultStatus.SERVER_ERROR, "Process item size must be between 1 and 5");
    }
    if(homePageDTO.getProductCategoryItems().size() != 6){
      throw new GeneralConfigException(CommonResultStatus.SERVER_ERROR, "Product category item size must be 6");
    }
    if(homePageDTO.getClientLogos().size() != 4){
      throw new GeneralConfigException(CommonResultStatus.SERVER_ERROR, "Client Logo size must be 4");
    }
    if(homePageDTO.getLeaders().size() != 2){
      throw new GeneralConfigException(CommonResultStatus.SERVER_ERROR, "Leader size must be 2");
    }

    GeneralConfig homePage = new GeneralConfig();

    try {
      ObjectMapper objectMapper = new ObjectMapper();

      String data = objectMapper.writeValueAsString(homePageDTO);
      homePage.setData(data);

    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }

    homePage.setType(GeneralConfigType.HOME);
    QueryWrapper<GeneralConfig> generalConfigQueryWrapper = new QueryWrapper<>();
    generalConfigQueryWrapper.eq("type", GeneralConfigType.HOME);
    GeneralConfig oldHomePage = this.getOne(generalConfigQueryWrapper);
    if(Objects.isNull(oldHomePage)){
      homePage.setCreateDate(LocalDateTime.now());
    }else {
      homePage.setId(oldHomePage.getId());
    }
    this.saveOrUpdate(homePage);

    return null;
  }
}
