package xyz.jecy.auth.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.util.CollectionUtils;
import xyz.jecy.api.user.response.UserAuthResponse;

/**
 * @Author dkw[dongkewei@xinzhili.cn]
 * @data 2019/12/24 4:17 下午
 */
public class AuthUtils {

  public static List<GrantedAuthority> extractAuthorities(UserAuthResponse response) {
    if (CollectionUtils.isEmpty(response.getRole())) {
      return List.of();
    }
    return response.getRole().stream().map(t -> new SimpleGrantedAuthority("ROLE_" + t))
        .collect(Collectors.toList());

  }
}
