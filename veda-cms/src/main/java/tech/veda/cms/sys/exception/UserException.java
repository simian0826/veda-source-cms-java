package tech.veda.cms.sys.exception;

import tech.veda.cms.common.ResultStatus;
import tech.veda.cms.common.BusinessException;

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
