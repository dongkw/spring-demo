package xyz.jecy.plugins.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import org.gradle.api.Project;
import org.gradle.api.Task;
import org.gradle.api.artifacts.Configuration;
import org.gradle.api.artifacts.ConfigurationContainer;
import org.gradle.api.artifacts.Dependency;
import org.gradle.api.artifacts.DependencySet;
import org.gradle.api.artifacts.UnknownConfigurationException;
import org.gradle.api.artifacts.dsl.DependencyHandler;
import redis.clients.jedis.Jedis;
import xyz.jecy.plugins.RedisUtil;

/**
 * @Author dkw[dongkewei@xinzhili.cn]
 * @data 2020/4/8 3:49 下午
 */
public class DependencyUtil {


  public static void setDependency(Project project) {

    RedisUtil redisUtil = new RedisUtil();
    Jedis jedis = redisUtil.getJedis();
    Map<String, String> map = jedis.hgetAll(PropertyUtil.getEnv(project));
    DependencyHandler dependencyHandler = project.getDependencies();
    ConfigurationContainer configurations = project.getConfigurations();

    try {
      Configuration configuration = configurations.getByName("api");
      DependencySet dependencies = configuration.getAllDependencies();
      dependencies.forEach(r -> {
        String version = map.get(r.getName());
        if (Objects.nonNull(version)) {
          dependencyHandler.add("api", r.getGroup() + ":" + r.getName() + ":" + version);
        }
      });
    } catch (UnknownConfigurationException e) {
      System.out.println("wrapper no configuration");
    }
  }

}

