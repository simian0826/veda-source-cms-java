package tech.vedaSource.cms.sys.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tech.vedaSource.cms.sys.model.Role;
import tech.vedaSource.cms.sys.model.User;

/**
 * @author Bruno
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

  @Query("select distinct u FROM User u join u.roles r where r.id=:roleId")
  Page<User> findRoleUsers(Long roleId, Pageable pageable);

}
