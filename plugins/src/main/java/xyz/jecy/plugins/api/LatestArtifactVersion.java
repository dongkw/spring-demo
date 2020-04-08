package xyz.jecy.plugins.api;

import org.gradle.api.DefaultTask;
import org.gradle.api.provider.Property;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.TaskAction;

public class LatestArtifactVersion extends DefaultTask {

  private final Property<String> serverUrl;

  public LatestArtifactVersion() {
    serverUrl = getProject().getObjects().property(String.class);
  }


  @Input
  public Property<String> getServerUrl() {
    return serverUrl;
  }


  @TaskAction
  public void resolveLatestVersion() {

  }

}