package xyz.jecy.order.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import xyz.jecy.order.bean.OrderInfo;
import xyz.jecy.user.bean.UserInfo;
import xyz.jecy.user.client.UserClient;
import xyz.jecy.util.response.Response;

/**
 * @Author dkw[dongkewei@xinzhili.cn]
 * @data 2019/12/6 3:53 下午
 */
@Service
public class OrderService {

  @Autowired
  private UserClient userClient;

  public List<OrderInfo> getOrderInfo(Long id) {

    Response response = userClient.getUser("name");
    System.out.println(response.getResult());
    return List.of(new OrderInfo());
  }

  public static void list() {
    List<List<String>> list = new ArrayList<>();
    list.add(List.of("111", "222", "444"));
    list.add(List.of("111", "222", "444"));

    List<Integer> is = list.stream().map(t -> Integer.parseInt(t.get(2)))
        .collect(Collectors.toList());
    System.out.println(is);

  }

  public static void main(String[] args) {
    list();
  }
}
