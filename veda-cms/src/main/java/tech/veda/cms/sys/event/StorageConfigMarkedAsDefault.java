package tech.veda.cms.sys.event;

import tech.veda.cms.sys.model.StorageConfig;
import tech.veda.cms.common.DomainEvent;

/**
 * @author Bruno
 */
public record StorageConfigMarkedAsDefault(StorageConfig config) implements DomainEvent {
}
