package xyz.jecy.auth.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import xyz.jecy.api.user.response.UserAuthResponse;
import xyz.jecy.auth.bean.UserToken;
import xyz.jecy.auth.util.AuthUtils;
import xyz.jecy.util.bean.ErrorCode;
import xyz.jecy.util.exception.FailureException;

/**
 * @Author dkw[dongkewei@xinzhili.cn]
 * @data 2019/03/09 下午 多个登录方式 通过验证码 微信openid等方式
 */
@Component
public class UserAuthenticationProvider3 implements AuthenticationProvider {

  @Autowired
  private UserService userService;

  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {

    String userName = String.valueOf(authentication.getPrincipal());
    String passWord = String.valueOf(authentication.getCredentials());

    UserAuthResponse response = new UserAuthResponse();
    response.setId("123");
    response.setName("aaa");
    response.setRole(List.of("AAA"));
    if (!passWord.equals("abb")){
      throw new UsernameNotFoundException(
          "Unauthorized client_id or username not found: " + userName);
    }

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
