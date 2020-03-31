package xyz.jecy.plugins;

import org.gradle.api.execution.TaskExecutionGraph;
import org.gradle.api.execution.TaskExecutionGraphListener;

/**
 * @Author dkw[dongkewei@xinzhili.cn]
 * @data 2020/3/31 3:08 下午
 */
public class ReleaseVersionListener implements TaskExecutionGraphListener {

  private static final String PATH = ":api:user-api:latestArtifactVersion";

  @Override
  public void graphPopulated(TaskExecutionGraph graph) {
    graph.getAllTasks().forEach(t -> System.out.println("~~~~~~~~`" + t.getPath()));

    if (graph.hasTask(PATH)) {
      graph.getAllTasks().stream().filter(t -> t.getPath() == PATH).findFirst().ifPresent(t -> {
        System.out.println(t.getPath());
        t.getProject().setVersion("1.1.0");
      });

    }

  }
}
