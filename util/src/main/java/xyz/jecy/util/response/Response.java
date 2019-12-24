package xyz.jecy.util.response;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;
import java.util.Objects;
import lombok.Data;
import xyz.jecy.util.bean.Code;
import xyz.jecy.util.bean.ErrorCode;

/**
 * @Author dkw[dongkewei@xinzhili.cn]
 * @data 2019/12/10 6:24 下午
 */
@Data
@JsonSerialize
public class Response<T> implements Serializable {

  public static final int SUCCESS_CODE = 200;

  public static final String SUCCESS_MESSAGE = "操作成功";

  private int code;
  private String message;
  private T result;


  private Response(int code, String message, T result) {
    setCode(code);
    setMessage(message);
    setResult(result);
  }


  public static <T> Response<T> initSuccess() {
    return initSuccess(null);
  }

  public static <T> Response<T> initSuccess(T data) {
    return new Response<T>(SUCCESS_CODE, SUCCESS_MESSAGE, data);
  }

  public static <T> Response<T> initError() {
    return initError(ErrorCode.INVALID_PARAMS);
  }

  public static <T> Response<T> initError(Code code) {
    return new Response<T>(code.getCode(), code.getDescription(), null);
  }

  public static <T> Response<T> initError(Code code, String message) {
    return new Response<T>(code.getCode(), message, null);
  }

  public boolean success() {
    return Objects.equals(SUCCESS_CODE, code);
  }

  public boolean error() {
    return !success();
  }

  public boolean error(Code errorCode) {
    return Objects.equals(errorCode.getCode(), code);
  }


}
