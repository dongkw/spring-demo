package xyz.jecy.user.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @Author dkw[dongkewei@xinzhili.cn]
 * @data 2019/12/23 11:55 上午
 */
public class AuthUtils {


  public String getAuth() {
    Authentication authentication = SecurityContextHolder.getContext()
        .getAuthentication();
    return null;
  }

}
