package tech.vedaSource.cms.sys.event;

import tech.vedaSource.cms.common.DomainEvent;
import tech.vedaSource.cms.sys.model.StorageConfig;

/**
 * @author Bruno
 */
public record StorageConfigMarkedAsDefault(StorageConfig config) implements DomainEvent {
}
