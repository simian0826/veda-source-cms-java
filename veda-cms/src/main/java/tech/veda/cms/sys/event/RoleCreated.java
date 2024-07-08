package tech.veda.cms.sys.event;

import tech.veda.cms.common.DomainEvent;
import tech.veda.cms.sys.model.Role;

/**
 * @author Bruno
 */
public record RoleCreated(Role role) implements DomainEvent {
}
