package xyz.jecy.user.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.jecy.api.order.client.OrderClient;
import xyz.jecy.api.user.bean.UserInfo;

/**
 * @Author dkw[dongkewei@xinzhili.cn]
 * @data 2019/12/6 3:53 下午
 */
@Service
public class UserService {

  @Autowired
  private OrderClient orderClient;

  public List<UserInfo> getUserInfo(String name){
    return List.of();
  }
}
