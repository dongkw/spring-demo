package xyz.jecy.plugins.server;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.gradle.api.Action;
import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.Task;
import org.gradle.api.artifacts.Configuration;
import org.gradle.api.artifacts.ConfigurationContainer;
import org.gradle.api.artifacts.Dependency;
import org.gradle.api.artifacts.DependencySet;
import org.gradle.api.artifacts.dsl.DependencyHandler;
import redis.clients.jedis.Jedis;
import xyz.jecy.plugins.BinaryRepositoryExtension;
import xyz.jecy.plugins.RedisUtil;

public class QuotePlugin implements Plugin<Project> {

  public void apply(Project project) {

    String env = project.hasProperty("env") ? project.getProperties().get("env").toString()
        : "dev";

//
    QuoteListener listener = new QuoteListener();
    project.getGradle().getTaskGraph().addTaskExecutionGraphListener(listener);


    project.getTasks()
        .register("quote11", DependenciesApplyTask.class, new Action<DependenciesApplyTask>() {
          @Override
          public void execute(DependenciesApplyTask dependenciesApplyTask) {
            dependenciesApplyTask.getEnv().set(env);
          }
        });
  }
}
