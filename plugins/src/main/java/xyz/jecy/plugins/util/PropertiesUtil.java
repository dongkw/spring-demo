package xyz.jecy.plugins.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * @Author dkw[dongkewei@xinzhili.cn]
 * @data 2020/3/30 4:06 下午
 */
public class PropertiesUtil {

  public static void main(String[] args) {
    handler("aa");
  }

  public static String handler(String serviceName) {
    String fileName="gradle.properties";
    try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
      stream.forEach(t->{



        System.out.println(t);
      });
    } catch (IOException e) {
      e.printStackTrace();
    }
    return "";
  }

  public static void write() {

  }


  private static void nextVersion() {

  }

}
