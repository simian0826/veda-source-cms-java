package tech.veda.cms.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tech.veda.cms.biz.common.Result;
import tech.veda.cms.biz.util.NetWorkUtil;
import tech.veda.cms.common.authz.RequiresPermissions;
import tech.veda.cms.sys.model.StorageConfig;
import tech.veda.cms.sys.model.StorageFile;
import tech.veda.cms.sys.service.dto.StorageFileDTO;
import tech.veda.cms.sys.service.StorageService;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Bruno
 */
@SecurityRequirement(name = "bearerAuth")
@RestController
@RequestMapping("/storage")
public class StorageController {

  private final StorageService storageService;

  public StorageController(StorageService storageService) {
    this.storageService = storageService;
  }

  @GetMapping("/configs")
  @RequiresPermissions("storage:view")
  public ResponseEntity<List<StorageConfig>> findConfigList() {
    List<StorageConfig> configList = storageService.findConfigList();
    return ResponseEntity.ok(configList);
  }

  @PostMapping("/configs")
  @RequiresPermissions("storage:create")
  public ResponseEntity<StorageConfig> createStorageConfig(@RequestBody StorageConfigRequest request) {
    StorageConfig config = storageService.createConfig(
      request.name(),
      request.type(),
      request.endpoint(),
      request.accessKey(),
      request.secretKey(),
      request.bucketName(),
      request.address(),
      request.storagePath()
    );
    return new ResponseEntity<>(config, HttpStatus.CREATED);
  }

  @PutMapping("/configs/{id}")
  @RequiresPermissions("storage:update")
  public ResponseEntity<StorageConfig> updateStorageConfig(@PathVariable("id") Long id, @RequestBody StorageConfigRequest request) {
    StorageConfig config = storageService.updateConfig(
      id,
      request.name(),
      request.type(),
      request.endpoint(),
      request.accessKey(),
      request.secretKey(),
      request.bucketName(),
      request.address(),
      request.storagePath()
    );
    return ResponseEntity.ok(config);
  }

  @DeleteMapping("/configs/{id}")
  @RequiresPermissions("storage:delete")
  public ResponseEntity<Void> deleteStorageConfig(@PathVariable Long id) {
    StorageConfig config = storageService.getConfig(id);
    storageService.deleteConfig(config);
    return ResponseEntity.noContent().build();
  }

  @PostMapping("/configs/{id}:markAsDefault")
  @RequiresPermissions("storage:markAsDefault")
  public ResponseEntity<Void> markAsDefaultStorageConfig(@PathVariable Long id) {
    StorageConfig config = storageService.getConfig(id);
    storageService.markAsDefault(config);
    return ResponseEntity.noContent().build();
  }

  @PostMapping("/upload")
  public Result<List<StorageFileDTO>> upload(@RequestParam(value = "storageId", required = false) String storageId,
													 @RequestParam("files") MultipartFile[] files, HttpServletRequest request) throws IOException {
    List<StorageFileDTO> responses = new ArrayList<>();
    // 获取服务器信息
    String domain = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();


    for (MultipartFile file : files) {
      String originalFilename = file.getOriginalFilename();
      StorageFileDTO storageFile = storageService.store(storageId, file.getInputStream(), file.getSize(), file.getContentType(), originalFilename, domain);
      responses.add(storageFile);
    }
    return Result.succ(responses);
  }

  @PostMapping("/uploadFile")
  public Result<List<StorageFileDTO>> uploadFile(@RequestParam(value = "storageId", required = false) String storageId,
                                          @RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
    List<StorageFileDTO> responses = new ArrayList<>();

    try {
//      String ipAddress = NetWorkUtil.getWifFiIPAddress();
      String domain = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
      String originalFilename = file.getOriginalFilename();
      StorageFileDTO storageFile = storageService.store(storageId, file.getInputStream(), file.getSize(), file.getContentType(), originalFilename, domain);
      responses.add(storageFile);
    }catch (UnknownHostException e){
      e.printStackTrace();
    }

    // 获取服务器信息


    return Result.succ(responses);
  }

  @PostMapping("/uploadFileByAntd")
  public Result<List<StorageFileDTO>> uploadFileByAntd(@RequestParam(value = "storageId", required = false) String storageId,
                                                  @RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
    List<StorageFileDTO> responses = new ArrayList<>();

    try {
//      String ipAddress = NetWorkUtil.getWifFiIPAddress();
      String domain = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
      String originalFilename = file.getOriginalFilename();
      StorageFileDTO storageFile = storageService.store(storageId, file.getInputStream(), file.getSize(), file.getContentType(), originalFilename, domain);
      responses.add(storageFile);
    }catch (UnknownHostException e){
      e.printStackTrace();
    }

    // 获取服务器信息


    return Result.succ(responses);
  }



  @GetMapping("/fetch/{key:.+}")
  public ResponseEntity<Resource> fetch(@PathVariable String key) {
    if (key == null) {
      return ResponseEntity.notFound().build();
    }
    if (key.contains("../")) {
      return ResponseEntity.badRequest().build();
    }
    StorageFile storageFile = storageService.getByKey(key);
    if (storageFile == null) {
      return ResponseEntity.notFound().build();
    }
    String type = storageFile.getType();
    MediaType mediaType = MediaType.parseMediaType(type);
    Resource resource = storageService.loadAsResource(key);
    if (resource == null) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok().contentType(mediaType).body(resource);
  }

  @GetMapping("/download/{key:.+}")
  public ResponseEntity<Resource> download(@PathVariable String key) {
    if (key == null) {
      return ResponseEntity.notFound().build();
    }
    if (key.contains("../")) {
      return ResponseEntity.badRequest().build();
    }
    StorageFile storageFile = storageService.getByKey(key);
    if (storageFile == null) {
      return ResponseEntity.notFound().build();
    }
    String type = storageFile.getType();
    MediaType mediaType = MediaType.parseMediaType(type);
    Resource file = storageService.loadAsResource(key);
    if (file == null) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok().contentType(mediaType)
      .header(HttpHeaders.CONTENT_DISPOSITION,
        "attachment; filename=\"" + storageFile.getName() + "\"")
      .body(file);
  }


  @DeleteMapping("/files/{key:.+}")
  public ResponseEntity<Void> delete(@PathVariable String key) {
    storageService.delete(key);
    return ResponseEntity.noContent().build();
  }

  record StorageConfigRequest(String name,
                              StorageConfig.Type type,
                              String endpoint,
                              String accessKey,
                              String secretKey,
                              String bucketName,
                              String address,
                              String storagePath
  ) {

  }

}
