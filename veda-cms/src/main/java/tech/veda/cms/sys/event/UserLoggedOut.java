package tech.veda.cms.sys.event;

import tech.veda.cms.common.DomainEvent;
import tech.veda.cms.sys.service.dto.UserinfoDTO;

/**
 * @author Bruno
 */
public record UserLoggedOut(UserinfoDTO userinfo) implements DomainEvent {
}
