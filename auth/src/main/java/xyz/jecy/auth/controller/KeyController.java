package xyz.jecy.auth.controller;

import java.security.KeyPair;
import java.security.interfaces.RSAKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.jecy.util.response.Response;

/**
 * @Author dkw[dongkewei@xinzhili.cn]
 * @data 2020/1/13 4:21 下午
 */
@RestController
public class KeyController {

  @Autowired
  private KeyPair keyPair;

//  @GetMapping("/key")
//  public Map<String, Object> getKey() {
//    RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
//    RSAKey key = new RSAKey.Builder(publicKey).build();
//    return new JWKSet(key).toJSONObject();
//  }

}
