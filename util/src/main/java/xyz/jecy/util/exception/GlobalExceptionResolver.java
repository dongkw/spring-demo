package xyz.jecy.util.exception;

import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.jecy.util.response.Response;

/**
 * @Author dkw[dongkewei@xinzhili.cn]
 * @data 2019/12/24 11:40 上午
 */
@ControllerAdvice
@Slf4j
@Component
public class GlobalExceptionResolver {

  @ResponseBody
  @ExceptionHandler(FailureException.class)
  public Response failException(FailureException e, HttpServletRequest req) {
    log.error("failure exception -> {} : {}", e.getClass(), e.getMessage());
    return Response.initError(e.getErrorCode());
  }
}
