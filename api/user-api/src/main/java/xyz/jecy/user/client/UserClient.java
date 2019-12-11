package xyz.jecy.user.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import xyz.jecy.util.response.Response;

/**
 * @Author dkw[dongkewei@xinzhili.cn]
 * @data 2019/12/6 3:45 下午
 */
@FeignClient("user-service")
public interface UserClient {

  @GetMapping("/user/name1")
  Response getUser(@RequestParam(value = "name", required = false) String name);

}
