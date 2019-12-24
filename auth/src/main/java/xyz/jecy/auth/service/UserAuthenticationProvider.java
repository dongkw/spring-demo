package xyz.jecy.auth.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import xyz.jecy.api.user.client.UserClient;
import xyz.jecy.api.user.error.UserErrorCode;
import xyz.jecy.api.user.response.UserAuthResponse;
import xyz.jecy.auth.bean.UserToken;
import xyz.jecy.auth.util.AuthUtils;
import xyz.jecy.util.exception.FailureException;
import xyz.jecy.util.response.Response;

/**
 * @Author dkw[dongkewei@xinzhili.cn]
 * @data 2019/12/23 2:30 下午
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

    UserToken token = new UserToken(authentication.getPrincipal(), authentication.getCredentials(),
        authorities);
    token.setUid("10086");
    token.setRole(List.of("DOCTOR", "PATIENT"));
    return token;
  }

  @Override
  public boolean supports(Class<?> authentication) {
    return true;
  }


}
