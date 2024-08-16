package tech.veda.cms.biz.service.vo;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author lizhiying
 */
@Builder
@Data
public class ProductPropertyVO {

  private String name;

  private List<ProductPropertyItemVO> items;
}
