package xyz.jecy.auth.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import xyz.jecy.api.user.response.UserAuthResponse;
import xyz.jecy.auth.bean.UserToken;
import xyz.jecy.auth.util.AuthUtils;

/**
 * @Author dkw[dongkewei@xinzhili.cn]
 * @data 2019/12/23 2:30 下午 首次获取token通过这个类验证
 */
@Component
public class UserAuthenticationProvider implements AuthenticationProvider {

  @Autowired
  private UserService userService;

  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {

    String userName = String.valueOf(authentication.getPrincipal());
    String passWord = String.valueOf(authentication.getCredentials());

    UserAuthResponse response = userService.getAuthResponse(userName, passWord);
    List<GrantedAuthority> authorities = AuthUtils.extractAuthorities(response);

    UserToken token = new UserToken(authentication.getPrincipal(),
        authentication.getCredentials(), authorities, response.getId());
    return token;
  }

  //如果有过个用户源 可以通过authentication来判断加载那个类
  @Override
  public boolean supports(Class<?> authentication) {
    return true;
  }


}
