package tech.vedaSource.cms.biz.exception;

import tech.vedaSource.cms.common.BusinessException;
import tech.vedaSource.cms.common.ResultStatus;

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
