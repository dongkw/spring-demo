package xyz.jecy.plugins.api;

import org.gradle.api.Action;
import org.gradle.api.Plugin;
import org.gradle.api.Project;
import xyz.jecy.plugins.BinaryRepositoryExtension;
import xyz.jecy.plugins.util.PropertyUtil;

public class BinaryRepositoryVersionPlugin implements Plugin<Project> {

  public void apply(Project project) {
    BinaryRepositoryExtension extension = project.getExtensions()
        .create("binaryRepo", BinaryRepositoryExtension.class, project);

    extension.getServerUrl().set(PropertyUtil.getServerUrl(project));
    extension.getEnv().set(PropertyUtil.getEnv(project));

    ReleaseVersionListener listener = new ReleaseVersionListener();
    project.getGradle().getTaskGraph().addTaskExecutionGraphListener(listener);

    project.getTasks().register("latestArtifactVersion", LatestArtifactVersion.class,
        new Action<LatestArtifactVersion>() {
          public void execute(LatestArtifactVersion latestArtifactVersion) {
            latestArtifactVersion.getServerUrl().set(extension.getServerUrl());
          }
        });

    project.getTasks().register("depend", DependenciesTask.class, new Action<DependenciesTask>() {
      @Override
      public void execute(DependenciesTask dependenciesTask) {
        dependenciesTask.getServerUrl().set(extension.getServerUrl());
        dependenciesTask.getEnv().set(extension.getEnv());
      }
    });

  }
}
