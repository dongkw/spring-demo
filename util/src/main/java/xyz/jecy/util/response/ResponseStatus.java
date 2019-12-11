package xyz.jecy.util.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author dkw[dongkewei@xinzhili.cn]
 * @data 2019/12/10 6:26 下午
 */
@Getter
@AllArgsConstructor
public enum ResponseStatus {

  SUCCESS("success"),
  ERROR("error");

  private String desc;

}
