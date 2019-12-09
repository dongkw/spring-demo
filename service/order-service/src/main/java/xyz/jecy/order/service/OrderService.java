package xyz.jecy.order.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import xyz.jecy.order.bean.OrderInfo;
import xyz.jecy.user.bean.UserInfo;
import xyz.jecy.user.client.UserClient;

/**
 * @Author dkw[dongkewei@xinzhili.cn]
 * @data 2019/12/6 3:53 下午
 */
@Service
public class OrderService {

  @Autowired
  private UserClient userClient;

  public List<OrderInfo> getOrderInfo(Long id) {

    ResponseEntity responseEntity = userClient.getUser("name");
    System.out.println(responseEntity.getBody());
    return List.of(new OrderInfo());
  }
}
