package xyz.jecy.plugins.server;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.ServiceLoader.Provider;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import lombok.Data;
import org.gradle.api.Task;
import org.gradle.api.artifacts.Configuration;
import org.gradle.api.artifacts.ConfigurationContainer;
import org.gradle.api.artifacts.Dependency;
import org.gradle.api.artifacts.DependencyConstraint;
import org.gradle.api.artifacts.DependencySet;
import org.gradle.api.artifacts.UnknownConfigurationException;
import org.gradle.api.artifacts.dsl.DependencyHandler;
import org.gradle.api.artifacts.type.ArtifactTypeContainer;
import org.gradle.api.execution.TaskExecutionGraph;
import org.gradle.api.execution.TaskExecutionGraphListener;
import org.gradle.api.internal.artifacts.DefaultDependencySet;
import org.gradle.api.internal.artifacts.ResolverResults;
import org.gradle.api.internal.artifacts.dependencies.DefaultExternalModuleDependency;
import org.gradle.api.internal.provider.DefaultProvider;
import org.gradle.api.tasks.TaskDependency;
import redis.clients.jedis.Jedis;
import xyz.jecy.plugins.RedisUtil;

/**
 * @Author dkw[dongkewei@xinzhili.cn]
 * @data 2020/3/31 3:08 下午
 */
@Data
public class QuoteListener implements TaskExecutionGraphListener {

  private static final String QUOTE_PATH = ":quote11";


  @Override
  public void graphPopulated(TaskExecutionGraph graph) {

    List<Task> tasks = graph.getAllTasks();

    tasks.stream().forEach(t -> System.out.println("```" + t.getPath()));
    if (tasks.size() > 0) {

      Task task = tasks.get(0);
      String env =
          task.getProject().hasProperty("env") ? task.getProject().getProperties().get("env")
              .toString() : "dev";
      RedisUtil redisUtil = new RedisUtil();
      Jedis jedis = redisUtil.getJedis();
      Map<String, String> map = jedis.hgetAll(env);
      System.out.println(map);

      DependencyHandler dependencyHandler = task.getProject().getDependencies();

      ConfigurationContainer configurations = task.getProject().getConfigurations();
      try{
        Configuration configuration = configurations.getByName("api");
        DependencySet dependencies = configuration.getAllDependencies();


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
      }catch (UnknownConfigurationException e){
        System.out.println("error");

      }
      }


  }

//    tasks.forEach(t -> {
//      if (t.getPath().endsWith(QUOTE_PATH)) {
//        DependenciesApplyTask task = (DependenciesApplyTask) t;
//        System.out.println(task.getEnv().get());
//
//        RedisUtil redisUtil = new RedisUtil();
//        Jedis jedis = redisUtil.getJedis();
//        Map<String, String> map = jedis.hgetAll(task.getEnv().get());
//        System.out.println(map);
//        DependencyHandler dependencyHandler = t.getProject().getDependencies();
//
//        ConfigurationContainer configurations = t.getProject().getConfigurations();
//            Configuration configuration = configurations.getByName("api");
//        DependencySet dependencies = configuration.getAllDependencies();
//
//            System.out.println("1" + dependencies);
//        List<Dependency> list = new ArrayList<>();
//        dependencies.removeIf(r -> {
//          boolean b = Objects.nonNull(map.get(r.getName()));
//          System.out.println("2" + b + r.getName());
//          if (b) {
//            list.add(r);
//          }
//          return b;
//        });
//        System.out.println("3" + list);
//        list.stream().forEach(d -> {
//          String version = map.get(d.getName());
//          dependencyHandler.add("api", d.getGroup() + ":" + d.getName() + ":" + version);
//        });
//      }
//
//    });
//
//  }
}
