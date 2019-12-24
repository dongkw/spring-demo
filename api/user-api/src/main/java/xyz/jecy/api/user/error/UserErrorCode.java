package xyz.jecy.api.user.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import xyz.jecy.util.bean.Code;

/**
 * @Author dkw[dongkewei@xinzhili.cn]
 * @data 2019/12/24 2:21 下午
 */
@AllArgsConstructor
@Getter
public enum UserErrorCode implements Code {

  USER_NOT_FOUND(1000, "未找到用户");

  private int code;
  private String description;
}
