package tech.vedaSource.cms.sys.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tech.vedaSource.cms.common.JsonUtils;
import tech.vedaSource.cms.VedaSourceCMSProperties;
import tech.vedaSource.cms.VedaSourceCMSProperties.Event;
import tech.vedaSource.cms.common.CollectionUtils;
import tech.vedaSource.cms.common.StringUtils;
import tech.vedaSource.cms.sys.model.StoredEvent;
import tech.vedaSource.cms.sys.repository.StoredEventRepository;
import tech.vedaSource.cms.sys.service.dto.LogDTO;
import tech.vedaSource.cms.sys.service.dto.PageDTO;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Bruno
 */
@Service
public class LogService {

  private final StoredEventRepository storedEventRepository;

  private final VedaSourceCMSProperties admin3Properties;

  public LogService(StoredEventRepository storedEventRepository, VedaSourceCMSProperties admin3Properties) {
    this.storedEventRepository = storedEventRepository;
    this.admin3Properties = admin3Properties;
  }

  public PageDTO<LogDTO> findLogs(Set<String> typeNames, Pageable pageable) {
    Map<String, Event> eventProps = admin3Properties.getEvents();
    Page<StoredEvent> page = storedEventRepository.findByTypeNameInOrderByOccurredOnDesc(
      CollectionUtils.isEmpty(typeNames) ? eventProps.keySet() : typeNames,
      pageable
    );
    return new PageDTO<>(page.getContent().stream()
      .map(e -> new LogDTO(e.getId(),
          StringUtils.simpleRenderTemplate(eventProps.get(e.getTypeName()).getLogTemplate(), JsonUtils.parseToMap(e.getEventBody())),
          e.getEventBody(),
          e.getTypeName(),
          e.getOccurredOn(),
          e.getUser()
        )
      )
      .collect(Collectors.toList()), page.getTotalElements());
  }

  public void cleanLogs() {
    storedEventRepository.deleteAll();
  }
}
