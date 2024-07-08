package tech.veda.cms.biz.exception;

import tech.veda.cms.common.ResultStatus;
import tech.veda.cms.common.BusinessException;

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
