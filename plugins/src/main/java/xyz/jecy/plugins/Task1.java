package xyz.jecy.plugins;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.gradle.api.DefaultTask;
import org.gradle.api.provider.Property;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.TaskAction;
import redis.clients.jedis.Jedis;
import xyz.jecy.util.exception.FailureException;


/**
 * @Author dkw[dongkewei@xinzhili.cn]
 * @data 2020/3/26 10:32 上午
 */
@Slf4j

public class Task1 extends DefaultTask {


  private Property<String> key;

  private String value;

  @Input
  public Property<String> getKey() {
    return key;
  }

  public void setKey(Property<String> key) {
    this.key = key;
  }

  @Input
  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  @TaskAction
  private void changeProperties() throws FailureException {
    RedisUtil redisUtil = new RedisUtil();
    Jedis jedis = redisUtil.getJedis();
    jedis.set(key.get(), value);
    jedis.close();
  }


}
