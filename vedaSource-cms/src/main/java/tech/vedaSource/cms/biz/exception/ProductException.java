package tech.vedaSource.cms.biz.exception;

import tech.vedaSource.cms.common.BusinessException;
import tech.vedaSource.cms.common.ResultStatus;

/**
 * @author lizhiying
 */
public class ProductException extends BusinessException {
  public ProductException(ResultStatus status) {
    super(status);
  }

  public ProductException(ResultStatus status, String message) {
    super(status, message);
  }
}
