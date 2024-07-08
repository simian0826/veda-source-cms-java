package tech.veda.cms.biz.exception;

import tech.veda.cms.common.ResultStatus;
import tech.veda.cms.common.BusinessException;

/**
 * @author lizhiying
 */
public class GeneralConfigException extends BusinessException {
  public GeneralConfigException(ResultStatus status) {
    super(status);
  }

  public GeneralConfigException(ResultStatus status, String message) {
    super(status, message);
  }
}
