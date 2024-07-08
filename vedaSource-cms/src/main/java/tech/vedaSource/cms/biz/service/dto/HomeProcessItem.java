package tech.vedaSource.cms.biz.service.dto;

import lombok.Data;

/**
 * @author lizhiying
 */
@Data
public class HomeProcessItem {
  private String title;
  private String subTitle;
  private String description;
  private String image;
  private ProcessInfo infoRight;
  private ProcessInfo infoLeft;
  private Integer productId;
}

@Data
class ProcessInfo {
  private String info;
  private String supplementary;
}
