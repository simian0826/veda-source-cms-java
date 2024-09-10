package tech.veda.cms.biz.service.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author lizhiying
 */
@EqualsAndHashCode(callSuper=false)
@Data
public class ContactUsListRequestDTO extends PageRequestDTO {

  private String name;

  private String email;

  private String subject;

}
