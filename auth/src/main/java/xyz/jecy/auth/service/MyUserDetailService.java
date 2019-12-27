package xyz.jecy.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import xyz.jecy.api.user.response.UserAuthResponse;
import xyz.jecy.auth.bean.AuthUser;
import xyz.jecy.auth.util.AuthUtils;

/**
 * @Author dkw[dongkewei@xinzhili.cn]
 * @data 2019/12/19 2:59 下午
 */

@Service
public class MyUserDetailService implements UserDetailsService {

  @Autowired
  private UserService userService;

  //刷新token时用来加自定义信息
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    UserAuthResponse response = userService.loadAuthResponse(username);

    return new AuthUser("name", "", AuthUtils.extractAuthorities(response), response.getId());
  }
}
