package xyz.jecy.plugins.server;

import org.gradle.api.DefaultTask;
import org.gradle.api.provider.Property;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.TaskAction;
import xyz.jecy.plugins.util.DependencyUtil;

public class DependenciesApplyTask extends DefaultTask {


  private final Property<String> env;

  public DependenciesApplyTask() {
    env = getProject().getObjects().property(String.class);
    System.out.println("111:"+env);
    DependencyUtil.setDependency(getProject());
  }

  @Input
  public Property<String> getEnv() {
    return env;
  }

  @TaskAction
  public void setDependencies() {

  }

}