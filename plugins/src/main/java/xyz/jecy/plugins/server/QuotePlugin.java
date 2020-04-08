package xyz.jecy.plugins.server;

import org.gradle.api.Action;
import org.gradle.api.Plugin;
import org.gradle.api.Project;
import xyz.jecy.plugins.util.PropertyUtil;

public class QuotePlugin implements Plugin<Project> {

  public void apply(Project project) {

    String env = PropertyUtil.getEnv(project);

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
