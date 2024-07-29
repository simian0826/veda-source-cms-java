package tech.veda.cms.biz.service.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author lizhiying
 */
@EqualsAndHashCode(callSuper=false)
@Data
public class ProjectListRequestDTO extends PageRequestDTO {

  private String type;

}
