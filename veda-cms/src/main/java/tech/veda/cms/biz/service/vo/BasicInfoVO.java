package tech.veda.cms.biz.service.vo;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

/**
 * @author lizhiying
 */
@Data
@Builder
public class BasicInfoVO {

  private String email;

  private String address;
}
