package xyz.jecy.user.controller;

import io.jsonwebtoken.Jwts;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xyz.jecy.api.user.bean.UserInfo;
import xyz.jecy.api.user.client.UserClient;

import xyz.jecy.api.user.response.UserAuthResponse;
import xyz.jecy.user.service.UserService;
import xyz.jecy.util.response.Response;

/**
 * @Author dkw[dongkewei@xinzhili.cn]
 * @data 2019/12/6 4:47 下午
 */
@RestController
public class UserController implements UserClient {

  @Autowired
  private UserService userService;

  public Response getUser(@RequestParam(value = "name", required = false) String name) {
    List<UserInfo> userInfos = userService.getUserInfo(name);
    return Response.initSuccess(userInfos);
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

  @GetMapping("/auth")
  public Object getAuth(
      Authentication authentication, HttpServletRequest request) {
    String header = request.getHeader("Authorization");
    String token = header.replace("Bearer ", "");
    return Jwts.parser()
        .setSigningKey("000000".getBytes(StandardCharsets.UTF_8))
        .parseClaimsJws(token)
        .getBody();

  }
}
