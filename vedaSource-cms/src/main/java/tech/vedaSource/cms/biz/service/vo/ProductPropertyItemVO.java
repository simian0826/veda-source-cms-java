package tech.vedaSource.cms.biz.service.vo;

import lombok.Builder;
import lombok.Data;

/**
 * @author lizhiying
 */
@Data
@Builder
public class ProductPropertyItemVO {
  private String label;

  private String value;
}
