package xyz.jecy.util.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import xyz.jecy.util.bean.Code;
import xyz.jecy.util.bean.ErrorCode;

/**
 * @Author dkw[dongkewei@xinzhili.cn]
 * @data 2019/12/24 11:47 上午
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class FailureException extends RuntimeException {

  private Code errorCode;

  public FailureException() {
    this(ErrorCode.REQUEST_FAILED);
  }

  public FailureException(Code code) {
    super(code.getDescription());
    this.errorCode = code;
  }

  public FailureException(Code code,String desc) {
    super(desc);
    this.errorCode = code;
  }

}
