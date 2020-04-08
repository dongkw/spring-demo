package xyz.jecy.plugins.api;

import org.gradle.api.DefaultTask;
import org.gradle.api.provider.Property;
import org.gradle.api.publish.PublishingExtension;
import org.gradle.api.publish.maven.MavenPublication;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.TaskAction;
import redis.clients.jedis.Jedis;
import xyz.jecy.plugins.RedisUtil;
import xyz.jecy.plugins.util.PropertiesUtil;

public class DependenciesTask extends DefaultTask {

  private final Property<String> serverUrl;

  private final Property<String> env;

  public DependenciesTask() {
    serverUrl = getProject().getObjects().property(String.class);
    env = getProject().getObjects().property(String.class);
  }


  @Input
  public Property<String> getServerUrl() {
    return serverUrl;
  }

  @Input
  public Property<String> getEnv() {
    return env;
  }

  @TaskAction
  public void setDependencies() {

    PublishingExtension extension = getProject().getExtensions()
        .getByType(PublishingExtension.class);
    MavenPublication mavenPublication = (MavenPublication) extension.getPublications()
        .findByName("maven");

    RedisUtil redisUtil = new RedisUtil();
    Jedis jedis = redisUtil.getJedis();
    getLogger().quiet(env.get());
    jedis.hset(env.get(), mavenPublication.getArtifactId(),
        PropertiesUtil.getVersion(serverUrl.get()));
    jedis.close();
  }

}