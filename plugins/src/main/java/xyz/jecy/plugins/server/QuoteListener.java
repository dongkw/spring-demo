package xyz.jecy.plugins.server;

import org.gradle.api.execution.TaskExecutionGraph;
import org.gradle.api.execution.TaskExecutionGraphListener;
import xyz.jecy.plugins.util.DependencyUtil;

/**
 * @Author dkw[dongkewei@xinzhili.cn]
 * @data 2020/3/31 3:08 下午
 */
public class QuoteListener implements TaskExecutionGraphListener {


  @Override
  public void graphPopulated(TaskExecutionGraph graph) {

    DependencyUtil.setDependency(graph.getAllTasks().get(0).getProject());

  }
}
