package xyz.jecy.util.bean;

import lombok.AllArgsConstructor;

/**
 * @Author dkw[dongkewei@xinzhili.cn]
 * @data 2019/12/11 10:27 上午
 */
@AllArgsConstructor
public enum ErrorCode implements Code {
  INVALID_PARAMS(400, "请求参数错误"),

  /**
   * 业务处理失败，通常不是由代码异常引起的，通常是业务原因，如规则不允许等
   */
  REQUEST_FAILED(450, "业务处理失败"),

  /**
   * 服务器异常，通常是由于代码逻辑错误导或外部服务不可用造成的致的非预期错误
   */
  SERVER_ERROR(500, "服务异常");

  private int code;
  private String description;

  @Override
  public int getCode() {
    return 0;
  }

  @Override
  public String getDescription() {
    return null;
  }
}
