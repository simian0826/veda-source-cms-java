package tech.veda.cms.biz.service.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author lizhiying
 */
@EqualsAndHashCode(callSuper=false)
@Data
public class ProductListRequestDTO extends PageRequestDTO {

  private String category;

}
