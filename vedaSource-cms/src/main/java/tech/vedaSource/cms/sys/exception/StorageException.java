package tech.vedaSource.cms.sys.exception;

import tech.vedaSource.cms.common.BusinessException;
import tech.vedaSource.cms.common.ResultStatus;

/**
 * @author Bruno
 */
public class StorageException extends BusinessException {

  public StorageException(ResultStatus status) {
    super(status);
  }

  public StorageException(ResultStatus status, String message) {
    super(status, message);
  }
}
