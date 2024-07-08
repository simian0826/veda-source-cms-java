package tech.vedaSource.cms.biz.service.dto;

import lombok.Data;
import tech.vedaSource.cms.biz.entity.HeroSection;
import tech.vedaSource.cms.biz.entity.Leader;

import java.util.List;

/**
 * @author lizhiying
 */
@Data
public class HomePageDTO {

  private List<HomeIntroductionItem> introductionItems;
  private List<HomeProcessItem> processItems;
  private List<HomeProductionCategoryItem> productCategoryItems;
  private List<Leader> leaders;
  private List<String> clientLogos;
}


