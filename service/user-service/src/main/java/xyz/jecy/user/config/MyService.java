package xyz.jecy.user.config;

import org.springframework.context.annotation.Conditional;

/**
 * @Author dkw[dongkewei@xinzhili.cn]
 * @data 2020/5/23 2:00 下午
 */
@Conditional(MyCondition.class)
public class MyService {


  public String test() {

    return "11";
  }

}
