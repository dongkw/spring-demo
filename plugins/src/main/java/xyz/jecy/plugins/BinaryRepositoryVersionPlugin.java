package xyz.jecy.plugins;

import org.gradle.api.Action;
import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.publish.plugins.PublishingPlugin;

public class BinaryRepositoryVersionPlugin implements Plugin<Project> {

  public void apply(Project project) {
    BinaryRepositoryExtension extension = project.getExtensions()
        .create("binaryRepo", BinaryRepositoryExtension.class, project);

    project.getTasks().register("latestArtifactVersion", LatestArtifactVersion.class,
        new Action<LatestArtifactVersion>() {

          public void execute(LatestArtifactVersion latestArtifactVersion) {
//            project.setVersion(extension.getServerUrl());
            latestArtifactVersion.getServerUrl().set(extension.getServerUrl());
          }
        });
//    project.getGradle().getTaskGraph().addTaskExecutionGraphListener(new ReleaseVersionListener());


  }
}
