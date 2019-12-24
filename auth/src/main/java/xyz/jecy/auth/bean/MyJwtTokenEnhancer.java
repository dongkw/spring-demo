package xyz.jecy.auth.bean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    List<String> role = null;
    Authentication userAuth = authentication.getUserAuthentication();
    if (userAuth instanceof UserToken) {
      userId = ((UserToken) userAuth).getUid();
      role = ((UserToken) userAuth).getRole();
    }
    info.put("userId", userId);
    info.put("role", role);
    DefaultOAuth2AccessToken token = new DefaultOAuth2AccessToken(
        accessToken);
    token.setAdditionalInformation(info);
    return token;
  }
}

