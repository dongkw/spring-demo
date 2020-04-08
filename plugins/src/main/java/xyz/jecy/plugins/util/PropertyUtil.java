package xyz.jecy.plugins.util;


import org.gradle.api.Project;
import org.gradle.api.Task;

/**
 * @Author dkw[dongkewei@xinzhili.cn]
 * @data 2020/4/8 3:51 下午
 */
public class PropertyUtil {

  public static String getEnv(Project project) {

    return project.hasProperty("env") ?
        project.getProperties().get("env").toString() : "dev";

  }

  public static String getServerUrl(Project project) {

    return project.hasProperty("serverUrl") ?
        project.getProperties().get("serverUrl").toString() : "version";

  }

}
