package xyz.jecy.user.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xyz.jecy.api.user.client.UserClient;
import xyz.jecy.api.user.response.UserAuthResponse;
import xyz.jecy.user.entity.User;
import xyz.jecy.user.service.IUserService;
import xyz.jecy.user.service.UserService;
import xyz.jecy.user.util.UserFactory;
import xyz.jecy.util.response.Response;

/**
 * @Author dkw[dongkewei@xinzhili.cn]
 * @data 2019/12/6 4:47 下午
 */
@RestController
@Slf4j
public class UserController implements UserClient {

  @Autowired
  private UserService userService;

  @Autowired
  private IUserService iUserService;

  public Response getUser(@RequestParam(value = "name", required = false) String name) {

    List<User> users = iUserService.list(UserFactory.of(name));

    return Response.initSuccess(UserFactory.api(users));
  }

  @Override
  public Response<UserAuthResponse> getUserAuth(@RequestParam(value = "name") String name,
      @RequestParam(value = "password") String password) {
    UserAuthResponse authResponse = userService.getUserAuth(name, password);

    return Response.initSuccess(authResponse);
  }

  @Override
  public Response<UserAuthResponse> loadUserAuth(@RequestParam(value = "name") String name) {
    UserAuthResponse authResponse = userService.loadUserAuth(name);
    return Response.initSuccess(authResponse);
  }

  public UserController() {
  }

  @GetMapping("/auth")
  public Object getAuth(
      Authentication authentication, HttpServletRequest request) {
    String header = request.getHeader("Authorization");
    String token = header.replace("Bearer ", "");
    return 11;
  }
}
