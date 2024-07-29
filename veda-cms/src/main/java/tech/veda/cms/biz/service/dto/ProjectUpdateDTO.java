package tech.veda.cms.biz.service.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=false)
@Data
public class ProjectUpdateDTO extends ProjectCreateDTO{
  private Integer id;

}
