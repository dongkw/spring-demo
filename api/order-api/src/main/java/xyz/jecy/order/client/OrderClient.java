package xyz.jecy.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import xyz.jecy.util.response.Response;

/**
 * @Author dkw[dongkewei@xinzhili.cn]
 * @data 2019/12/6 3:45 下午
 */
@FeignClient("order-service")
public interface OrderClient {

  @GetMapping("/order")
  Response getOrder(@RequestParam(value = "id", required = false) Long id);

}
