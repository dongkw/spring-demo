package xyz.jecy.api.user.bean.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author dkw[dongkewei@xinzhili.cn]
 * @data 2020/1/7 5:44 下午
 */
@AllArgsConstructor
@Getter
public enum Role {
  DOCTOR(1, "医生"),
  PATIENT(2, "患者");

  @EnumValue
  @JsonValue
  private int code;

  private String desc;
}
