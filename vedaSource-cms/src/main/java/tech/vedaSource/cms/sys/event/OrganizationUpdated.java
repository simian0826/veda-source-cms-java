package tech.vedaSource.cms.sys.event;

import tech.vedaSource.cms.common.DomainEvent;
import tech.vedaSource.cms.sys.model.Organization;

/**
 * @author Bruno
 */
public record OrganizationUpdated(Organization organization) implements DomainEvent {
}
