package tech.veda.cms.sys.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.veda.cms.sys.model.StoredEvent;

import java.util.Set;

/**
 * @author Bruno
 */
@Repository
public interface StoredEventRepository extends JpaRepository<StoredEvent, Long> {

  Page<StoredEvent> findByTypeNameInOrderByOccurredOnDesc(Set<String> typeNames, Pageable pageable);

}
