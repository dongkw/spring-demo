package xyz.jecy.auth.bean;

import java.util.Collection;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

/**
 * @Author dkw[dongkewei@xinzhili.cn]
 * @data 2019/12/23 2:40 下午
 */
@EqualsAndHashCode(callSuper = false)
public class UserToken extends UsernamePasswordAuthenticationToken {

  @Getter
  private String userId;

  public UserToken(Object principal, Object credentials) {
    super(principal, credentials);
  }

  public UserToken(Object principal, Object credentials,
      Collection<? extends GrantedAuthority> authorities, String userId) {
    super(principal, credentials, authorities);
    this.userId = userId;
  }
}
