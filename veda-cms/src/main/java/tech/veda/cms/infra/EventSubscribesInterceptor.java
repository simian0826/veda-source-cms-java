package tech.veda.cms.infra;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import tech.veda.cms.common.DomainEvent;
import tech.veda.cms.common.EventStore;
import tech.veda.cms.sys.event.RoleDeleted;
import tech.veda.cms.sys.event.RoleUpdated;
import tech.veda.cms.common.DomainEventPublisher;
import tech.veda.cms.sys.event.ResourceUpdated;
import tech.veda.cms.sys.service.SessionService;
import tech.veda.cms.sys.event.ResourceDeleted;

/**
 * 通用事件处理拦截器，
 *
 * @author Bruno
 */
public class EventSubscribesInterceptor implements HandlerInterceptor {
  private final EventStore eventStore;
  private final SessionService sessionService;

  public EventSubscribesInterceptor(EventStore eventStore, SessionService sessionService) {
    this.eventStore = eventStore;
    this.sessionService = sessionService;
  }

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
    DomainEventPublisher.instance().reset();
    DomainEventPublisher.instance().subscribe(DomainEvent.class, eventStore::append);
    //发生以下事件, 刷新会话
    DomainEventPublisher.instance().subscribe(RoleUpdated.class, event -> sessionService.refresh());
    DomainEventPublisher.instance().subscribe(RoleDeleted.class, event -> sessionService.refresh());
    DomainEventPublisher.instance().subscribe(ResourceUpdated.class, event -> sessionService.refresh());
    DomainEventPublisher.instance().subscribe(ResourceDeleted.class, event -> sessionService.refresh());
    return true;
  }


}
