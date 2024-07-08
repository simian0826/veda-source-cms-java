package tech.veda.cms.sys.service.dto;

import tech.veda.cms.sys.model.Resource;

import java.util.List;

/**
 * @author Bruno
 */
public record ResourceTreeDTO(Long id, String name, Resource.Type type, String permission, String url, String icon,
							  List<ResourceTreeDTO> children, Long parentId, String parentName) {

}
