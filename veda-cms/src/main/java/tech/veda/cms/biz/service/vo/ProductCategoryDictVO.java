package tech.veda.cms.biz.service.vo;

import lombok.Builder;
import lombok.Data;

/**
 * @author lizhiying
 */
@Builder
@Data
public class ProductCategoryDictVO {

  private String label;
  private String value;
}
