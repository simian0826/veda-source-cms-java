package tech.veda.cms.biz.service.vo;

import lombok.Builder;
import lombok.Data;
import tech.veda.cms.biz.service.dto.IntroductionInfo;

@Builder
@Data
public class HomeIntroductionItemVO {
  private String title;
  private String subTitle;
  private String description;
  private String image;
  private IntroductionInfo infoRight;
  private IntroductionInfo infoLeft;
  private ProductVO product;
}
