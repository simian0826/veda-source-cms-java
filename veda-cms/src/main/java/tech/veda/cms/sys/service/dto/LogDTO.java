package tech.veda.cms.sys.service.dto;

import tech.veda.cms.sys.model.User;

import java.time.LocalDateTime;

/**
 * @author Bruno
 */
public record LogDTO(Long id, String content, String eventBody, String typeName, LocalDateTime occurredOn, User user) {
}
