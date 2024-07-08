package tech.vedaSource.cms.sys.event;

import tech.vedaSource.cms.common.DomainEvent;
import tech.vedaSource.cms.sys.model.Role;

/**
 * @author Bruno
 */
public record RoleDeleted(Role role) implements DomainEvent {
}
