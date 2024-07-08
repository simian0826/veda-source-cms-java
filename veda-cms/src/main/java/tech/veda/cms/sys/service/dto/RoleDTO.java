package tech.veda.cms.sys.service.dto;

import java.util.List;

/**
 * @author Bruno
 */
public record RoleDTO(Long id, String name, String description, boolean available, List<Long> resourceIds) {
}
