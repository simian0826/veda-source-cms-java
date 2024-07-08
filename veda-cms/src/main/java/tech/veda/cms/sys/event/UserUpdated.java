package tech.veda.cms.sys.event;

import tech.veda.cms.common.DomainEvent;
import tech.veda.cms.sys.model.User;

/**
 * @author Bruno
 */
public record UserUpdated(User user) implements DomainEvent {
}
