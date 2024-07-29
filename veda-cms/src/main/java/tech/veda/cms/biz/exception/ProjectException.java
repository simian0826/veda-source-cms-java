package tech.veda.cms.biz.exception;

import tech.veda.cms.common.BusinessException;
import tech.veda.cms.common.ResultStatus;

/**
 * @author lizhiying
 */
public class ProjectException extends BusinessException {
  public ProjectException(ResultStatus status) {
    super(status);
  }

  public ProjectException(ResultStatus status, String message) {
    super(status, message);
  }
}
