package xyz.jecy.plugins;


import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisUtil {

  // Redis 服务器 IP
  private String address = "localhost";

  // Redis的端口号
  private int port = 6379;

//    // 访问密码
//    private String password = "test123";

  // 获取 Jedis 实例
  public Jedis getJedis() {
    return new Jedis(address, port);

  }
}



