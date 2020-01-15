package xyz.jecy.auth.config;

import java.security.KeyPair;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;
import xyz.jecy.auth.service.MyJwtTokenEnhancer;
import xyz.jecy.auth.service.MyUserDetailService;

/**
 * @Author dkw[dongkewei@xinzhili.cn]
 * @data 2019/12/19 10:13 上午
 */
@Configuration
@EnableAuthorizationServer
public class OauthConfig extends AuthorizationServerConfigurerAdapter {

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private RedisConnectionFactory connectionFactory;

  @Autowired
  private MyUserDetailService userDetailService;


  @Autowired
  private MyJwtTokenEnhancer jwtTokenEnhancer;

  @Override
  public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
    security.allowFormAuthenticationForClients().passwordEncoder(new BCryptPasswordEncoder());
  }

  @Override
  public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

    clients.inMemory()
        .withClient("client")
        .autoApprove(true)

        //设置accessToken过期时长
        .accessTokenValiditySeconds(12 * 60 * 60)
        //设置refreshToken过期时长
        .refreshTokenValiditySeconds(7 * 24 * 60 * 60)
        //设置secret解密模式
        .secret(new BCryptPasswordEncoder().encode("secret"))
        //oauth2的四种模式 和刷新token
        .authorizedGrantTypes("authorization_code", "refresh_token", "implicit",
            "client_credentials", "password")
        .scopes("app", "web", "all")
        //重定向地址
        .redirectUris("http://www.baidu.com");

  }

  @Override
  public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {

    TokenEnhancerChain enhancerChain = new TokenEnhancerChain();
    //自定义token 第一个是加自定义字段 第二个是jwt token
    enhancerChain.setTokenEnhancers(List.of(jwtTokenEnhancer, accessTokenConverter()));

    endpoints.authenticationManager(authenticationManager)

        //可以复用refresh_token
        .reuseRefreshTokens(true)
        //自定义userDetailService
        .userDetailsService(userDetailService)
//        .tokenStore(tokenStore())
        .tokenEnhancer(enhancerChain);

  }

  @Bean
  public JwtAccessTokenConverter accessTokenConverter() {
    JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
    converter.setKeyPair(keyPair());
    return converter;
  }

  @Bean
  public KeyPair keyPair() {
    //用非对称加密token 生成jwt.jks 用keytool生成
    KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(
        new ClassPathResource("jwt.jks"), "jecyxyz".toCharArray());
    return keyStoreKeyFactory.getKeyPair("jwt", "jecyxyz".toCharArray());
  }

  @Bean
  public TokenStore tokenStore() {

    //把token存到redis里
    RedisTokenStore redisTokenStore = new RedisTokenStore(connectionFactory);
    redisTokenStore.setPrefix("auth-token:");
    return redisTokenStore;
  }

}