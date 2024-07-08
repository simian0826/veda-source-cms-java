package tech.vedaSource.cms.sys.service.dto;

import tech.vedaSource.cms.sys.model.User;

import java.time.LocalDateTime;

/**
 * @author Bruno
 */
public record OrgUserDTO(Long id,
                         String username,
                         String avatar,
                         User.Gender gender,
                         User.State state,
                         String orgFullName,
                         LocalDateTime createdTime) {
}
