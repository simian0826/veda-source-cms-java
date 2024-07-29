package tech.veda.cms.biz.service.vo;

import lombok.Data;
import tech.veda.cms.biz.entity.Person;
import tech.veda.cms.biz.service.dto.HomeIntroductionItem;
import tech.veda.cms.biz.service.dto.HomeProcessItem;
import tech.veda.cms.biz.service.dto.HomeProductionCategoryItem;

import java.util.List;

/**
 * @author lizhiying
 */
@Data
public class HomePageVO {
  private List<HomeIntroductionItem> introductionItems;
  private List<HomeProcessItem> processItems;
  private List<HomeProductionCategoryItem> productCategoryItems;
  private List<Person> leaders;
  private List<String> clientLogos;
}


