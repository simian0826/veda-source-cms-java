package tech.vedaSource.cms.biz.service.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author lizhiying
 */
@EqualsAndHashCode(callSuper=false)
@Data
public class ProductUpdateRequestDTO extends ProductCreateRequestDTO {

  private Integer id;
}
