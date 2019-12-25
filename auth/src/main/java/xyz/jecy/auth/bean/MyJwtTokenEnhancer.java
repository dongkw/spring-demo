package xyz.jecy.auth.bean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import lombok.Data;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

/**
 * @Author dkw[dongkewei@xinzhili.cn]
 * @data 2019/12/23 11:38 上午
 */

@Component
public class MyJwtTokenEnhancer implements TokenEnhancer {

  @Override
  public OAuth2AccessToken enhance(OAuth2AccessToken accessToken,
      OAuth2Authentication authentication) {
    Map<String, Object> info = new HashMap<>();
    String userId = "";

    Authentication userAuth = authentication.getUserAuthentication();
    if (userAuth instanceof UserToken) {
      userId = ((UserToken) userAuth).getUserId();
    } else {
      if (userAuth.getPrincipal() instanceof AuthUser) {
        userId = (((AuthUser) userAuth.getPrincipal()).getUserId());
      }
    }
    info.put("userId", userId);
    DefaultOAuth2AccessToken token = new DefaultOAuth2AccessToken(
        accessToken);
    token.setAdditionalInformation(info);
    return token;
  }
}

