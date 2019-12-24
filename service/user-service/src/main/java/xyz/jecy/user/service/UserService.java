package xyz.jecy.user.service;

import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.jecy.api.order.client.OrderClient;
import xyz.jecy.api.user.bean.UserInfo;
import xyz.jecy.api.user.error.UserErrorCode;
import xyz.jecy.api.user.response.UserAuthResponse;
import xyz.jecy.util.bean.ErrorCode;
import xyz.jecy.util.exception.FailureException;

/**
 * @Author dkw[dongkewei@xinzhili.cn]
 * @data 2019/12/6 3:53 下午
 */
@Service
public class UserService {

  @Autowired
  private OrderClient orderClient;

  public List<UserInfo> getUserInfo(String name) {
    return List.of();
  }


  public UserAuthResponse getUserAuth(String name, String password) {
    UserAuthResponse response = null;

    if (Objects.equals(name, "name") && Objects.equals(password, "pwd")) {
      response = new UserAuthResponse();
      response.setId("1");
      response.setName("name");
      response.setRole(List.of("DOCTOR", "PATIENT"));
      return response;

    }
    throw new FailureException(UserErrorCode.USER_NOT_FOUND);
  }

  public UserAuthResponse loadUserAuth(String name) {
    UserAuthResponse response = null;

    if (Objects.equals(name, "name")) {
      response = new UserAuthResponse();
      response.setId("1");
      response.setName("name");
      response.setRole(List.of("DOCTOR", "PATIENT"));
      return response;

    }
    throw new FailureException(UserErrorCode.USER_NOT_FOUND);
  }
}
