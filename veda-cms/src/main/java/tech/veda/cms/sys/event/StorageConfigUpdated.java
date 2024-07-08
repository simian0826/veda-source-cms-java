package tech.veda.cms.sys.event;

import tech.veda.cms.common.DomainEvent;
import tech.veda.cms.sys.model.StorageConfig;

/**
 * @author Bruno
 */
public record StorageConfigUpdated(StorageConfig config) implements DomainEvent {
}
