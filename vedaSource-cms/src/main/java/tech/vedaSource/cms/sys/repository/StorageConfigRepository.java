package tech.vedaSource.cms.sys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tech.vedaSource.cms.sys.model.StorageConfig;

/**
 * @author Bruno
 */
@Repository
public interface StorageConfigRepository extends JpaRepository<StorageConfig, Long> {

  @Query("from StorageConfig where isDefault=true")
  StorageConfig getDefaultConfig();

  StorageConfig getByStorageId(String storageId);

}
