package tech.veda.cms.sys.service.dto;

import tech.veda.cms.sys.model.Role;
import tech.veda.cms.sys.model.User;

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
