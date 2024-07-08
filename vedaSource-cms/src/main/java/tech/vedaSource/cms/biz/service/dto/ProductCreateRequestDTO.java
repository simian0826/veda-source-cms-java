package tech.vedaSource.cms.biz.service.dto;

import lombok.Data;

import java.util.List;

/**
 * @author lizhiying
 */
@Data
public class ProductCreateRequestDTO {

  private String name;

  private String category;

  private String description;

  private List<String> imgs;

  private List<String> certificate;

  private List<ProductPropertyDTO> properties;
  private List<ProductPropertyDTO> additionalProperties;

}
