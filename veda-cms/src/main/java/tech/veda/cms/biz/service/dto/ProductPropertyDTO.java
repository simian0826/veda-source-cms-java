package tech.veda.cms.biz.service.dto;

import lombok.Data;

import java.util.List;

/**
 * @author lizhiying
 */
@Data
public class ProductPropertyDTO {

  private String name;

  private List<ProductPropertyItemDTO> items;
}
