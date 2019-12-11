package xyz.jecy.util.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;
import java.util.Objects;
import lombok.Data;
import xyz.jecy.util.bean.Code;

/**
 * @Author dkw[dongkewei@xinzhili.cn]
 * @data 2019/12/10 6:24 下午
 */
@Data
@JsonSerialize
public class Response<T> implements Serializable {

  private static final ObjectMapper MAPPER = new ObjectMapper();

  private ResponseStatus status;
  private T result;


  private Response() {
  }

  private Response(ResponseStatus status) {
    this.status = status;
  }

  private Response(ResponseStatus status, T result) {
    setStatus(status);
    setResult(result);
  }


  public static <T> Response<T> initSuccess() {
    return new Response<T>(ResponseStatus.SUCCESS);
  }

  public static <T> Response<T> initSuccess(T data) {
    return new Response<T>(ResponseStatus.SUCCESS, data);
  }

  public static <T> Response<T> initError() {
    return new Response<T>(ResponseStatus.ERROR);
  }

  private static Response<Code> initError(Code code) {
    return new Response<Code>(ResponseStatus.ERROR, code);
  }

  public static <T> Response<T> initError(T data) {
    return new Response<T>(ResponseStatus.ERROR, data);
  }

  public boolean isSuccess() {
    return Objects.equals(status, ResponseStatus.SUCCESS);
  }

  private boolean isError() {
    return Objects.equals(status, ResponseStatus.ERROR);
  }


}
