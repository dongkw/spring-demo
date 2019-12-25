package xyz.jecy.auth.bean;

import java.util.Collection;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

/**
 * @Author dkw[dongkewei@xinzhili.cn]
 * @data 2019/12/25 4:29 下午
 */
@EqualsAndHashCode(callSuper=false)
public class AuthUser extends User {

  @Getter
  private String userId;


  public AuthUser(String username, String password,
      Collection<? extends GrantedAuthority> authorities,String userId) {
    super(username, password, authorities);
    this.userId=userId;
  }

  public AuthUser(String username, String password, boolean enabled, boolean accountNonExpired,
      boolean credentialsNonExpired, boolean accountNonLocked,
      Collection<? extends GrantedAuthority> authorities) {
    super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked,
        authorities);
  }
}
