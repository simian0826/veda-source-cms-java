package tech.veda.cms.sys.event;

import tech.veda.cms.common.DomainEvent;
import tech.veda.cms.sys.model.Resource;

/**
 * @author Bruno
 */
public record ResourceDeleted(Resource resource) implements DomainEvent {
}
