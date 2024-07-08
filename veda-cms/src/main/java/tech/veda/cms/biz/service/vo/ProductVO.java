package tech.veda.cms.biz.service.vo;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author lizhiying
 */
@Builder
@Data
public class ProductVO {

  private Integer id;

  private String name;

  private String category;

  private String description;

  private List<String> imgs;

  private List<String> certificate;

  private List<ProductPropertyVO> properties;
}
