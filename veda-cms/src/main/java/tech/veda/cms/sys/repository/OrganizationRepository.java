package tech.veda.cms.sys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tech.veda.cms.sys.model.Organization;

import java.util.List;

/**
 * @author Bruno
 */
@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {

  @Query("from Organization org where org.parent.id=:parentId")
  List<Organization> findByParentId(Long parentId);
}
