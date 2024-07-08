package tech.vedaSource.cms.sys.event;

import tech.vedaSource.cms.common.DomainEvent;
import tech.vedaSource.cms.sys.model.Resource;

/**
 * @author Bruno
 */
public record ResourceCreated(Resource resource) implements DomainEvent {
}
