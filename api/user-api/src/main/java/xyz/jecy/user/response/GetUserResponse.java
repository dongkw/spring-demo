package xyz.jecy.user.response;

import java.util.List;
import lombok.Data;
import xyz.jecy.user.bean.UserInfo;

/**
 * @Author dkw[dongkewei@xinzhili.cn]
 * @data 2019/12/6 3:44 下午
 */
@Data
public class GetUserResponse {

  private List<UserInfo> users;
  private int total;
}
