package xyz.jecy.plugins.server;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.gradle.api.DefaultTask;
import org.gradle.api.artifacts.Configuration;
import org.gradle.api.artifacts.ConfigurationContainer;
import org.gradle.api.artifacts.Dependency;
import org.gradle.api.artifacts.DependencySet;
import org.gradle.api.artifacts.dsl.DependencyHandler;
import org.gradle.api.provider.Property;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.TaskAction;
import redis.clients.jedis.Jedis;
import xyz.jecy.plugins.RedisUtil;

public class DependenciesApplyTask extends DefaultTask {


  private final Property<String> env;

  public DependenciesApplyTask() {
    env = getProject().getObjects().property(String.class);

    DependencyHandler dependencyHandler = getProject().getDependencies();
    ConfigurationContainer configurations = getProject().getConfigurations();
    Configuration configuration = configurations.getByName("api");

    DependencySet dependencies = configuration.getAllDependencies();

    RedisUtil redisUtil = new RedisUtil();
    Jedis jedis = redisUtil.getJedis();

    String env1 =
        getProject().hasProperty("env") ? getProject().getProperties().get("env")
            .toString()
            : "dev";

    Map<String, String> map = jedis.hgetAll(env1);
    System.out.println(map);
    System.out.println("1" + dependencies);
    List<Dependency> list = new ArrayList<>();
    dependencies.removeIf(r -> {
      boolean b = Objects.nonNull(map.get(r.getName()));
      System.out.println("2" + b + r.getName());
      if (b) {
        list.add(r);
      }
      return b;
    });
    System.out.println("3" + list);
    list.stream().forEach(d -> {
      String version = map.get(d.getName());
      dependencyHandler.add("api", d.getGroup() + ":" + d.getName() + ":" + version);
    });
  }


  @Input
  public Property<String> getEnv() {
    return env;
  }

  @TaskAction
  public void setDependencies() {

  }

}