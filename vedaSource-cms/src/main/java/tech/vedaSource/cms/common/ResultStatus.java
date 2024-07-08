package tech.vedaSource.cms.common;

/**
 * @author Bruno
 */
public interface ResultStatus {
  /**
   * 错误码
   */
  int getCode();

  /**
   * 错误信息
   */
  String getMessage();
}
