package xyz.jecy.order.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xyz.jecy.order.bean.OrderInfo;
import xyz.jecy.order.client.OrderClient;
import xyz.jecy.order.service.OrderService;
import xyz.jecy.user.bean.UserInfo;

/**
 * @Author dkw[dongkewei@xinzhili.cn]
 * @data 2019/12/6 4:47 下午
 */
@RestController
public class OrderController implements OrderClient {

  @Autowired
  private OrderService orderService;


  @Override
  public ResponseEntity getOrder(@RequestParam(value = "id", required = false) Long id) {
    List<OrderInfo> orderInfos = orderService.getOrderInfo(1L);
    return ResponseEntity.ok(orderInfos);
  }
  @GetMapping("/ids")
  public ResponseEntity getUser(@RequestParam(value = "name", required = false) String name) {
    List<UserInfo> userInfos = List.of();
    return ResponseEntity.ok(userInfos);
  }

}
