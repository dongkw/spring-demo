package xyz.jecy.plugins;

import org.gradle.api.Project;
import org.gradle.api.provider.Property;

/**
 * @Author dkw[dongkewei@xinzhili.cn]
 * @data 2020/3/26 2:34 下午
 */
public class ExtData {

  private final Property<String> key;


  public ExtData(Project project) {
    this.key = project.getObjects().property(String.class);
  }

  public Property<String> getKey() {
    return key;
  }
}
