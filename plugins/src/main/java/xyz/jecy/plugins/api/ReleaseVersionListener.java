package xyz.jecy.plugins.api;

import java.util.List;
import lombok.Data;
import org.gradle.api.Task;
import org.gradle.api.execution.TaskExecutionGraph;
import org.gradle.api.execution.TaskExecutionGraphListener;
import org.gradle.api.publish.PublishingExtension;
import org.gradle.api.publish.maven.MavenPublication;
import xyz.jecy.plugins.util.PropertiesUtil;

/**
 * @Author dkw[dongkewei@xinzhili.cn]
 * @data 2020/3/31 3:08 下午
 */
@Data
public class ReleaseVersionListener implements TaskExecutionGraphListener {

  private static final String PATH = ":latestArtifactVersion";
  private static final String QUOTE_PATH = ":quote11";


  @Override
  public void graphPopulated(TaskExecutionGraph graph) {

    List<Task> tasks = graph.getAllTasks();

    tasks.forEach(t -> {
      if (t.getPath().endsWith(PATH)) {
        LatestArtifactVersion l = (LatestArtifactVersion) t;
        String version = PropertiesUtil.getVersion(l.getServerUrl().get());
        PropertiesUtil.handler(l.getServerUrl().get());
        t.getProject().setVersion(PropertiesUtil.nextVersion(version));
        PublishingExtension extension = l.getProject().getExtensions()
            .getByType(PublishingExtension.class);
        MavenPublication mavenPublication = (MavenPublication) extension.getPublications()
            .findByName("maven");
        mavenPublication.setVersion(PropertiesUtil.nextVersion(version));
      }

    });


  }
}
