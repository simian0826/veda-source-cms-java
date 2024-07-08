package tech.vedaSource.cms.sys.exception;

import tech.vedaSource.cms.common.BusinessException;
import tech.vedaSource.cms.common.ResultStatus;

/**
 * @author Bruno
 */
public class UserException extends BusinessException {

  public UserException(ResultStatus status) {
    super(status);
  }

  public UserException(ResultStatus status, String message) {
    super(status, message);
  }
}
