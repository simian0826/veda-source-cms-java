package tech.veda.cms.infra.service;

import org.springframework.stereotype.Service;
import tech.veda.cms.common.*;
import tech.veda.cms.sys.model.StoredEvent;
import tech.veda.cms.sys.repository.StoredEventRepository;
import tech.veda.cms.sys.repository.UserRepository;
import tech.veda.cms.sys.service.dto.UserinfoDTO;

/**
 * @author Bruno
 */
@Service
public class EventStoreService implements EventStore {

  private final StoredEventRepository storedEventRepository;
  private final UserRepository userRepository;

  public EventStoreService(StoredEventRepository storedEventRepository, UserRepository userRepository) {
    this.storedEventRepository = storedEventRepository;
    this.userRepository = userRepository;
  }

  @Override
  public void append(DomainEvent aDomainEvent) {
    StoredEvent storedEvent = new StoredEvent();
    storedEvent.setEventBody(JsonUtils.stringify(aDomainEvent));
    storedEvent.setOccurredOn(aDomainEvent.occurredOn());
    storedEvent.setTypeName(aDomainEvent.getClass().getTypeName());
    UserinfoDTO userInfo = (UserinfoDTO) SessionItemHolder.getItem(Constants.SESSION_CURRENT_USER);
    if (userInfo != null) {
      storedEvent.setUser(userRepository.getReferenceById(userInfo.userId()));
    }
    storedEventRepository.save(storedEvent);
  }

}
