package tech.vedaSource.cms.sys.event;

import tech.vedaSource.cms.common.DomainEvent;
import tech.vedaSource.cms.sys.model.User;

/**
 * @author Bruno
 */
public record UserUpdated(User user) implements DomainEvent {
}
