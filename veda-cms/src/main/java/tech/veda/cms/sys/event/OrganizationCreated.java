package tech.veda.cms.sys.event;

import tech.veda.cms.common.DomainEvent;
import tech.veda.cms.sys.model.Organization;

/**
 * @author Bruno
 */
public record OrganizationCreated(Organization organization) implements DomainEvent {
}
