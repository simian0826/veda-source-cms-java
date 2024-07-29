package tech.veda.cms.biz.service.dto;

import lombok.Data;

import java.util.List;

/**
 * @author lizhiying
 */
@Data
public class HomePageDTO {


  private List<HomeIntroductionItem> introductionItems;
  private List<HomeProcessItem> processItems;
  private List<HomeProductionCategoryItem> productCategoryItems;
  private List<Integer> leaders;
  private List<String> clientLogos;
}


