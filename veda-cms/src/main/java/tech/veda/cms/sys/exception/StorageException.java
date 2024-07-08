package tech.veda.cms.sys.exception;

import tech.veda.cms.common.ResultStatus;
import tech.veda.cms.common.BusinessException;

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
