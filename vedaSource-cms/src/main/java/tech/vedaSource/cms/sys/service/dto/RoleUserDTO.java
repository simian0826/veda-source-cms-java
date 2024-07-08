package tech.vedaSource.cms.sys.service.dto;

import tech.vedaSource.cms.sys.model.User;
import tech.vedaSource.cms.sys.model.Role;

import java.time.LocalDateTime;
import java.util.Set;

/**
 * @author Bruno
 */
public record RoleUserDTO(Long id,
                          String username,
                          String avatar,
                          User.Gender gender,
                          User.State state,
                          Set<Role> roles,
                          LocalDateTime createdTime) {

}
