package tech.vedaSource.cms.sys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tech.vedaSource.cms.sys.model.Resource;

import java.util.Set;

/**
 * @author Bruno
 */
@Repository
public interface ResourceRepository extends JpaRepository<Resource, Long> {

  @Query("from Resource where id in (:resourceIds)")
  Set<Resource> findByIds(Set<Long> resourceIds);

}
