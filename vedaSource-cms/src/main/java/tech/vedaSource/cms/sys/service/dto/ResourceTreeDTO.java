package tech.vedaSource.cms.sys.service.dto;

import tech.vedaSource.cms.sys.model.Resource.Type;

import java.util.List;

/**
 * @author Bruno
 */
public record ResourceTreeDTO(Long id, String name, Type type, String permission, String url, String icon,
                              List<ResourceTreeDTO> children, Long parentId, String parentName) {

}
