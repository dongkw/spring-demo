package xyz.jecy.api.order.response;

import java.util.List;
import lombok.Data;
import xyz.jecy.api.order.bean.OrderInfo;

/**
 * @Author dkw[dongkewei@xinzhili.cn]
 * @data 2019/12/6 3:44 下午
 */
@Data
public class GetOrderResponse {

  private List<OrderInfo> users;
  private int total;
}
