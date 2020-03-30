package xyz.jecy.generator;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

/**
 * @Author dkw[dongkewei@xinzhili.cn]
 * @data 2020/3/24 2:40 下午
 */
public class MyFristPlugin implements Plugin<Project> {

  @Override
  public void apply(Project target) {
    target.getTasks().create("generator", MyTask.class);
  }
}
