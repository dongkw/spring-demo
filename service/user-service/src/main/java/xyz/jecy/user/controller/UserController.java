package xyz.jecy.user.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xyz.jecy.user.bean.UserInfo;
import xyz.jecy.user.client.UserClient;
import xyz.jecy.user.service.UserService;

/**
 * @Author dkw[dongkewei@xinzhili.cn]
 * @data 2019/12/6 4:47 下午
 */
@RestController
public class UserController implements UserClient {

  @Autowired
  private UserService userService;

  public ResponseEntity getUser(@RequestParam(value = "name", required = false) String name) {
    List<UserInfo> userInfos = userService.getUserInfo(name);
    return ResponseEntity.ok(userInfos);
  }

}
