package xyz.jecy.api.user.response;

import java.util.List;
import lombok.Data;

/**
 * @Author dkw[dongkewei@xinzhili.cn]
 * @data 2019/12/24 10:23 上午
 */
@Data
public class UserAuthResponse {

  private String id;
  private String name;
  private List<String> role;

}
