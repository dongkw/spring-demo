package xyz.jecy.order.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xyz.jecy.api.order.bean.OrderInfo;
import xyz.jecy.api.order.client.OrderClient;

import xyz.jecy.api.user.bean.UserInfo;
import xyz.jecy.order.service.OrderService;
import xyz.jecy.util.response.Response;

/**
 * @Author dkw[dongkewei@xinzhili.cn]
 * @data 2019/12/6 4:47 下午
 */
@RestController
public class OrderController implements OrderClient {

  @Autowired
  private OrderService orderService;


  @Override
  public Response getOrder(@RequestParam(value = "id", required = false) Long id) {
    List<OrderInfo> orderInfos = orderService.getOrderInfo(1L);
    return Response.initSuccess(orderInfos);
  }

  @GetMapping("/ids")
  public ResponseEntity getUser(@RequestParam(value = "name", required = false) String name) {
    List<UserInfo> userInfos = List.of();
    return ResponseEntity.ok(userInfos);
  }

}
