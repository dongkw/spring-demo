package xyz.jecy.plugins.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.gradle.api.Project;

/**
 * @Author dkw[dongkewei@xinzhili.cn]
 * @data 2020/3/30 4:06 下午
 */
public class PropertiesUtil {


  private static final String PLACE = "-";



  private static Path getPath(String fileName) {
    Path path = Paths.get(fileName);
    if (fileName.contains("../../../../")) {
      return path;
    }
    if (Files.notExists(path)) {
      return getPath("../" + fileName);
    }
    return path;
  }

  public static void handler(Project project, String serviceName) {

    Path path = getPath("gradle.properties");
    List<String> list = null;
    try {
      list = Files.readAllLines(path);
    } catch (IOException e) {
      e.printStackTrace();
    }
    list = list.stream().map(t -> {
      if (t.contains(serviceName)) {
        String[] s = t.split("=");
        String version = nextVersion(s[1]);
        project.setVersion(version);
        return s[0] + "=" + version;
      }
      return t;
    }).collect(Collectors.toList());
    try {
      Files.write(path, list, StandardOpenOption.WRITE);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void write() {
  }


  public static String nextVersion(String version) {
    String now = TimeUtils.getYMD();
    String[] v = version.split(PLACE);
    if (version.contains(now)) {
      if (v.length == 2) {
        return v[0] + PLACE + "1" + PLACE + v[1];
      } else if (v.length == 3) {
        int i = Integer.parseInt(v[1]);
        return v[0] + PLACE + ++i + PLACE + v[2];
      }
    }
    return now + "-" + v[v.length - 1];
  }

}
