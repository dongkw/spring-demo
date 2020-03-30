package xyz.jecy.generator;

import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;
import xyz.jecy.generator.GeneratorService;
import xyz.jecy.util.exception.FailureException;

/**
 * @Author dkw[dongkewei@xinzhili.cn]
 * @data 2020/3/24 3:53 下午
 */
public class MyTask extends DefaultTask {

  @TaskAction
  private void generator() throws FailureException {
    GeneratorService service = new GeneratorService();
    service.generateCode();

  }
}
