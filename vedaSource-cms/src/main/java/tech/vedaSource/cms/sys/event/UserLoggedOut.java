package tech.vedaSource.cms.sys.event;

import tech.vedaSource.cms.common.DomainEvent;
import tech.vedaSource.cms.sys.service.dto.UserinfoDTO;

/**
 * @author Bruno
 */
public record UserLoggedOut(UserinfoDTO userinfo) implements DomainEvent {
}
