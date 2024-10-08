package tech.veda.cms.sys.service;

import org.springframework.core.io.Resource;
import tech.veda.cms.sys.model.StorageConfig;
import tech.veda.cms.sys.model.StorageFile;
import tech.veda.cms.sys.service.dto.StorageFileDTO;

import java.io.InputStream;
import java.util.List;

/**
 * @author Bruno
 */
public interface StorageService {

  List<StorageConfig> findConfigList();

  StorageConfig getConfig(Long id);

  StorageConfig createConfig(String name, StorageConfig.Type type, String endpoint, String accessKey, String secretKey, String bucketName, String address, String storagePath);

  StorageConfig updateConfig(Long id, String name, StorageConfig.Type type, String endpoint, String bucketName, String accessKey, String secretKey, String address, String storagePath);

  void deleteConfig(StorageConfig storageConfig);

  void markAsDefault(StorageConfig storageConfig);

  StorageFileDTO store(String storageId, InputStream inputStream, long contentLength, String contentType, String filename, String domain);

  void delete(String key);

  StorageFile getByKey(String key);

  Resource loadAsResource(String key);
}
