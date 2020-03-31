package xyz.jecy.plugins.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;


public class TimeUtils {

  private final static DateTimeFormatter dayFormatter = DateTimeFormatter.ofPattern("yyyyMMdd")
      .withLocale(Locale.CHINA);

  public static String getYMD() {

    return LocalDateTime.now().format(dayFormatter);
  }

  public static void main(String[] args) {
    System.out.println(getYMD());
  }

}
