package tech.veda.cms.biz.service.impl;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.veda.cms.biz.common.GeneralConfigType;
import tech.veda.cms.biz.common.Result;
import tech.veda.cms.biz.entity.GeneralConfig;
import tech.veda.cms.biz.entity.Person;
import tech.veda.cms.biz.entity.Product;
import tech.veda.cms.biz.exception.GeneralConfigException;
import tech.veda.cms.biz.mapper.GeneralConfigMapper;
import tech.veda.cms.biz.service.IGeneralConfigService;
import tech.veda.cms.biz.service.IPersonService;
import tech.veda.cms.biz.service.IProductService;
import tech.veda.cms.biz.service.dto.*;
import tech.veda.cms.biz.service.dto.AboutUsQualityItem;
import tech.veda.cms.biz.service.vo.*;
import tech.veda.cms.common.CommonResultStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

  @Autowired
  IPersonService leaderService;

  @Autowired
  IProductService productService;

  @Override
  public Boolean updateHomePage(HomePageDTO homePageDTO) {

    if(homePageDTO.getProcessItems().size() != 3){
      throw new GeneralConfigException(CommonResultStatus.SERVER_ERROR, "Process item size must be 3");
    }

    if(homePageDTO.getIntroductionItems().isEmpty() || homePageDTO.getIntroductionItems().size() > 5){
      throw new GeneralConfigException(CommonResultStatus.SERVER_ERROR, "Introduction item size must be between 1 and 5");
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
    String jsonString = JSON.toJSONString(homePageDTO);
    homePage.setData(jsonString);

    homePage.setType(GeneralConfigType.HOME);
    QueryWrapper<GeneralConfig> generalConfigQueryWrapper = new QueryWrapper<>();
    generalConfigQueryWrapper.eq("type", GeneralConfigType.HOME);
    Optional<GeneralConfig> oldHomePage = this.getOneOpt(generalConfigQueryWrapper);
    if(oldHomePage.isPresent()){
      homePage.setId(oldHomePage.get().getId());
    }else {
      homePage.setCreateDate(LocalDateTime.now());
    }

    return this.saveOrUpdate(homePage);
  }

  @Override
  public HomePageVO findHomePage() {
    QueryWrapper<GeneralConfig> generalConfigQueryWrapper = new QueryWrapper<>();
    generalConfigQueryWrapper.eq("type", GeneralConfigType.HOME);
    GeneralConfig homePageGeneralConfig = this.getOne(generalConfigQueryWrapper);
    JSONObject homePageDataJsonObject = JSON.parseObject(homePageGeneralConfig.getData());
    List<HomeProcessItem> processItems = (List<HomeProcessItem>) homePageDataJsonObject.get("processItems");
    List<HomeProductionCategoryItem> productCategoryItems = homePageDataJsonObject.getList("productCategoryItems", HomeProductionCategoryItem.class);
    List<String> clientLogos = (List<String>) homePageDataJsonObject.get("clientLogos");
    List<HomeIntroductionItem> introductionItems = homePageDataJsonObject.getList("introductionItems", HomeIntroductionItem.class);
    List<HomeIntroductionItemVO> introductionItemsVOS = introductionItems.stream().map(item -> {
      ProductVO productVO = productService.findProductCMS(item.getProductId());
      return  HomeIntroductionItemVO.builder()
        .image(item.getImage())
        .title(item.getTitle())
        .subTitle(item.getTitle())
        .product(productVO)
        .description(item.getDescription())
        .infoRight(item.getInfoRight())
        .infoLeft(item.getInfoLeft())
        .build();

    }).toList();
    List<Integer> leaderIds = (List<Integer>) homePageDataJsonObject.get("leaders");
    List<Person> leaders = new ArrayList<>();
    leaderIds.forEach(id -> {
      Optional<Person> optionalLeader = leaderService.getOptById(id);
      optionalLeader.ifPresent(leaders::add);
    });

    HomePageVO homePageVO = new HomePageVO();
    homePageVO.setProcessItems(processItems);
    homePageVO.setIntroductionItems(introductionItemsVOS);
    homePageVO.setProductCategoryItems(productCategoryItems);
    homePageVO.setClientLogos(clientLogos);
    homePageVO.setLeaders(leaders);
    return homePageVO;
  }

  @Override
  public AboutUsVO findAboutUsPage() {
    QueryWrapper<GeneralConfig> generalConfigQueryWrapper = new QueryWrapper<>();
    generalConfigQueryWrapper.eq("type", GeneralConfigType.ABOUT_US);
    GeneralConfig aboutUsGeneralConfig = this.getOne(generalConfigQueryWrapper);
    JSONObject aboutUsDataJsonObject = JSON.parseObject(aboutUsGeneralConfig.getData());
    List<Integer> teamMemberIds =  aboutUsDataJsonObject.getList("teamMembers", Integer.class);
    List<Person> teamMembers = new ArrayList<>();
    teamMemberIds.forEach(id -> {
      Optional<Person> optionalLeader = leaderService.getOptById(id);
      optionalLeader.ifPresent(teamMembers::add);
    });
    List<AboutUsQualityItem> qualityItems = aboutUsDataJsonObject.getList("qualityItems", AboutUsQualityItem.class);
    String needHelpHeader = aboutUsDataJsonObject.getString("needHelpHeader");
    String needHelpDesc = aboutUsDataJsonObject.getString("needHelpDesc");

    return AboutUsVO.builder()
            .teamMembers(teamMembers)
            .needHelpDesc(needHelpDesc)
            .needHelpHeader(needHelpHeader)
            .qualityItems(qualityItems)
            .build();
  }

  @Override
  public Boolean updateAboutUsPage(AboutUsDTO aboutUsDTO) {

    if(aboutUsDTO.getQualityItems().size() != 4){
      throw new GeneralConfigException(CommonResultStatus.SERVER_ERROR, "Quality item size must be 4");
    }

    for(AboutUsQualityItem aboutUsQualityItem : aboutUsDTO.getQualityItems()){
      if(aboutUsQualityItem.getDesc() == null || aboutUsQualityItem.getDesc().isEmpty()){
        throw new GeneralConfigException(CommonResultStatus.SERVER_ERROR, "Quality item description can't be empty");
      }
      if(aboutUsQualityItem.getTitle() == null || aboutUsQualityItem.getTitle().isEmpty()){
        throw new GeneralConfigException(CommonResultStatus.SERVER_ERROR, "Quality item title can't be empty");
      }
      if(aboutUsQualityItem.getImage() == null || aboutUsQualityItem.getImage().isEmpty()){
        throw new GeneralConfigException(CommonResultStatus.SERVER_ERROR, "Quality item image can't be empty");
      }
    }
    if(aboutUsDTO.getTeamMembers().isEmpty()){
      throw new GeneralConfigException(CommonResultStatus.SERVER_ERROR, "Team member can't be empty");
    }
    if(aboutUsDTO.getNeedHelpDesc() == null || aboutUsDTO.getNeedHelpDesc().isEmpty()){
      throw new GeneralConfigException(CommonResultStatus.SERVER_ERROR, "Need-help-description can't be empty");
    }

    if(aboutUsDTO.getNeedHelpHeader() == null || aboutUsDTO.getNeedHelpHeader().isEmpty()){
      throw new GeneralConfigException(CommonResultStatus.SERVER_ERROR, "Need-help-header can't be empty");
    }


    GeneralConfig aboutUsPage = new GeneralConfig();

    String jsonString = JSON.toJSONString(aboutUsDTO);
    aboutUsPage.setData(jsonString);
    aboutUsPage.setType(GeneralConfigType.ABOUT_US);
    QueryWrapper<GeneralConfig> generalConfigQueryWrapper = new QueryWrapper<>();
    generalConfigQueryWrapper.eq("type", GeneralConfigType.ABOUT_US);
    Optional<GeneralConfig> oldAboutUsPage = this.getOneOpt(generalConfigQueryWrapper);
    if(oldAboutUsPage.isPresent()){
      aboutUsPage.setId(oldAboutUsPage.get().getId());
    }else {
      aboutUsPage.setCreateDate(LocalDateTime.now());
    }

    return this.saveOrUpdate(aboutUsPage);
  }

  @Override
  public Boolean updateBasicInfo(BasicInfoDTO basicInfoDTO) {

    GeneralConfig basicInfo = new GeneralConfig();

    String jsonString = JSON.toJSONString(basicInfoDTO);
    basicInfo.setData(jsonString);
    basicInfo.setType(GeneralConfigType.BASIC_INFO);
    QueryWrapper<GeneralConfig> generalConfigQueryWrapper = new QueryWrapper<>();
    generalConfigQueryWrapper.eq("type", GeneralConfigType.BASIC_INFO);
    Optional<GeneralConfig> oldBasicInfo = this.getOneOpt(generalConfigQueryWrapper);
    if(oldBasicInfo.isPresent()){
      basicInfo.setId(oldBasicInfo.get().getId());
    }else {
      basicInfo.setCreateDate(LocalDateTime.now());
    }

    return this.saveOrUpdate(basicInfo);

  }

  @Override
  public BasicInfoVO findBasicInfo() {
    QueryWrapper<GeneralConfig> generalConfigQueryWrapper = new QueryWrapper<>();
    generalConfigQueryWrapper.eq("type", GeneralConfigType.BASIC_INFO);
    GeneralConfig basicInfoGeneralConfig = this.getOne(generalConfigQueryWrapper);
    JSONObject basicInfoDataJsonObject = JSON.parseObject(basicInfoGeneralConfig.getData());
    return BasicInfoVO.builder().address(basicInfoDataJsonObject.getString("address")).email(basicInfoDataJsonObject.getString("email")).build();
  }
}
