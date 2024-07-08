package tech.vedaSource.cms.sys.service.dto;

import tech.vedaSource.cms.sys.model.UserCredential;

import java.io.Serializable;
import java.util.Set;

/**
 * @author Bruno
 */
public record UserinfoDTO(String token, Long userId, String username, String avatar,
                          Credential credential, Set<String> permissions) implements Serializable {

  public record Credential(String identifier, UserCredential.IdentityType type) {
  }

}
