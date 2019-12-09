package xyz.jecy.order.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xyz.jecy.order.bean.OrderInfo;
import xyz.jecy.order.service.OrderService;

/**
 * @Author dkw[dongkewei@xinzhili.cn]
 * @data 2019/12/6 4:47 下午
 */
@RestController
public class OrderController {

  @Autowired
  private OrderService orderService;

  public ResponseEntity getOrder(@RequestParam(value = "id", required = false) Long id) {

    List<OrderInfo> orderInfos = orderService.getOrderInfo(id);
    return ResponseEntity.ok(orderInfos);
  }
}
