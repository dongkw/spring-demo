package xyz.jecy.gateway.config;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import xyz.jecy.gateway.error.ErrorCode;
import xyz.jecy.util.response.Response;

/**
 * @Author dkw[dongkewei@xinzhili.cn]
 * @data 2020/1/10 3:43 下午
 */
@Component
public class AuthorizationFilter implements GlobalFilter, Ordered {

  @Value("permit.all")
  private List<String> permitAll;

  @Override
  public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
    ServerHttpRequest request = exchange.getRequest();
    if (needCheck(request)) {
      String accessToken = getToken(request);
      if(StringUtils.isEmpty(accessToken)){
        exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
        return exchange.getResponse().setComplete();
      }
    }

    return chain.filter(exchange);
  }

//  ServerHttpResponse response = exchange.getResponse(); //设置header
//  HttpHeaders httpHeaders = response.getHeaders();
//  httpHeaders.add(&quot;Content-Type&quot;, &quot;application/json; charset=UTF-8&quot;);
//  httpHeaders.add(&quot;Cache-Control&quot;, &quot;no-store, no-cache, must-revalidate, max-age=0&quot;); //设置body
//  String bodyPackage = &quot;{\&quot;status\&quot;:\&quot;110\&quot;,\&quot;message\&quot;:\&quot;未登录或登录超时\&quot;}&quot;;
//  DataBuffer bodyDataBuffer = response.bufferFactory().wrap(bodyPackage.getBytes()); //返回
//  return response.writeWith(Mono.just(bodyDataBuffer));


  private boolean needCheck(ServerHttpRequest request) {
    URI uri = request.getURI();
    String requestUri = uri.getPath();
    return !permitAll.contains(requestUri);
  }


  private String getToken(ServerHttpRequest request) {
    List<String> headers = request.getHeaders().get("Authorization");
    if (!CollectionUtils.isEmpty(headers)) {
      String value = headers.get(0);
      String authHeaderValue = value.substring(OAuth2AccessToken.BEARER_TYPE.length()).trim();
      // Add this here for the auth details later. Would be better to change the signature of this method.
      int commaIndex = authHeaderValue.indexOf(',');
      if (commaIndex > 0) {
        authHeaderValue = authHeaderValue.substring(0, commaIndex);
      }
      return authHeaderValue;

    }
    return "";
  }

  @Override
  public int getOrder() {
    return 0;
  }
}
