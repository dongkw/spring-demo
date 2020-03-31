package xyz.jecy.plugins;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Map;
import org.gradle.api.DefaultTask;
import org.gradle.api.provider.Property;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.TaskAction;
import redis.clients.jedis.Jedis;
import xyz.jecy.plugins.util.PropertiesUtil;

public class LatestArtifactVersion extends DefaultTask {

  private final Property<String> serverUrl;

  public LatestArtifactVersion() {
    serverUrl = getProject().getObjects().property(String.class);
  }


  @Input
  public Property<String> getServerUrl() {
    return serverUrl;
  }


  @TaskAction
  public void resolveLatestVersion() {
    // Access the raw value during the execution phase of the build lifecycle
    System.out.println("service name" + serverUrl.get());

//    getProject().setVersion(serverUrl.get());

//    getProject().setVersion();
//    getProject().getTasks().;

//    getAnt().getProperties().put("asdfas","asdfas");

    PropertiesUtil.handler(getProject(),serverUrl.get());

//    RedisUtil redisUtil = new RedisUtil();
//    Jedis jedis = redisUtil.getJedis();
//    jedis.setnx(serverUrl.get(), toTimestamp(LocalDateTime.now()) + "");
//    jedis.close();

    // do additional work
  }

  public static long toTimestamp(LocalDateTime localDateTime) {
    return localDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
  }
}