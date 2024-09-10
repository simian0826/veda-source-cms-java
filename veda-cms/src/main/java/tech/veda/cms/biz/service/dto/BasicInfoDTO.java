package tech.veda.cms.biz.service.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class BasicInfoDTO {
  @Email(message = "Email should not be valid")
  private String email;
  @NotEmpty(message = "Address should not be empty")
  private String address;
}
