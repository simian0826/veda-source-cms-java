package tech.vedaSource.cms.common;

/**
 * @author Bruno
 */
public class BusinessException extends RuntimeException {
  private final ResultStatus status;

  public BusinessException(ResultStatus status) {
    super(status.getMessage());
    this.status = status;
  }

  public BusinessException(ResultStatus status, String message) {
    super(message);
    this.status = status;
  }

  public ResultStatus getStatus() {
    return status;
  }


}
