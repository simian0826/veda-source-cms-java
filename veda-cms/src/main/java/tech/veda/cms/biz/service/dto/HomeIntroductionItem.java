package tech.veda.cms.biz.service.dto;

import lombok.Data;

/**
 * @author lizhiying
 */
@Data
public class HomeIntroductionItem {
  private String title;
  private String subTitle;
  private String description;
  private String image;
  private IntroductionInfo infoRight;
  private IntroductionInfo infoLeft;
  private Integer productId;
}

@Data
class IntroductionInfo {
  private String info;
  private String supplementary;
}
