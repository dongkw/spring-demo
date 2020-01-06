package xyz.jecy.generator;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.config.ConstVal;
import com.baomidou.mybatisplus.generator.config.builder.ConfigBuilder;
import com.baomidou.mybatisplus.generator.engine.AbstractTemplateEngine;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Map;
import java.util.Properties;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;

/**
 * @Author dkw[dongkewei@xinzhili.cn]
 * @data 2020/1/3 2:33 下午
 */
public class MyTemp extends AbstractTemplateEngine {

  private static final String DOT_VM = ".vm";
  private VelocityEngine velocityEngine;

  @Override
  public MyTemp init(ConfigBuilder configBuilder) {
    super.init(configBuilder);
    if (null == velocityEngine) {
      Properties p = new Properties();
      p.setProperty(ConstVal.VM_LOAD_PATH_KEY, ConstVal.VM_LOAD_PATH_VALUE);
      p.setProperty(Velocity.FILE_RESOURCE_LOADER_PATH, StringPool.EMPTY);
      p.setProperty(Velocity.ENCODING_DEFAULT, ConstVal.UTF8);
      p.setProperty(Velocity.INPUT_ENCODING, ConstVal.UTF8);
      p.setProperty("file.resource.loader.unicode", StringPool.TRUE);
      velocityEngine = new VelocityEngine(p);
    }
    return this;
  }


  @Override
  public void writer(Map<String, Object> objectMap, String templatePath, String outputFile)
      throws Exception {
    if (templatePath.contains("controller")) {
      return;
    }
    if (StringUtils.isBlank(templatePath)) {
      return;
    }
    Template template = velocityEngine.getTemplate(templatePath, ConstVal.UTF8);
    try (FileOutputStream fos = new FileOutputStream(outputFile);
        OutputStreamWriter ow = new OutputStreamWriter(fos, ConstVal.UTF8);
        BufferedWriter writer = new BufferedWriter(ow)) {
      template.merge(new VelocityContext(objectMap), writer);
    }
    logger.debug("模板:" + templatePath + ";  文件:" + outputFile);
  }


  @Override
  public String templateFilePath(String filePath) {
    if (null == filePath || filePath.contains(DOT_VM)) {
      return filePath;
    }
    return filePath + DOT_VM;
  }
}
