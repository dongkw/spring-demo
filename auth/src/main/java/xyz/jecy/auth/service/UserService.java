package xyz.jecy.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import xyz.jecy.api.user.client.UserClient;
import xyz.jecy.api.user.error.UserErrorCode;
import xyz.jecy.api.user.response.UserAuthResponse;
import xyz.jecy.util.exception.FailureException;
import xyz.jecy.util.response.Response;

/**
 * @Author dkw[dongkewei@xinzhili.cn]
 * @data 2019/12/24 10:41 上午
 */
@Service
public class UserService {

  @Autowired
  private UserClient userClient;

  public UserAuthResponse getAuthResponse(String userName, String passWord) {
    Response<UserAuthResponse> response = userClient.getUserAuth(userName, passWord);
    if (response.error()) {
      if (response.error(UserErrorCode.USER_NOT_FOUND)) {
        throw new UsernameNotFoundException(
            "Unauthorized client_id or username not found: " + userName);
      }
      throw new FailureException(UserErrorCode.USER_NOT_FOUND);
    }
    return response.getResult();
  }

  public UserAuthResponse loadAuthResponse(String userName) {
    Response<UserAuthResponse> response = userClient.loadUserAuth(userName);
    if (response.error()) {
      if (response.error(UserErrorCode.USER_NOT_FOUND)) {
        throw new UsernameNotFoundException(
            "Unauthorized client_id or username not found: " + userName);
      }
      throw new FailureException(UserErrorCode.USER_NOT_FOUND);
    }
    return response.getResult();
  }
}
