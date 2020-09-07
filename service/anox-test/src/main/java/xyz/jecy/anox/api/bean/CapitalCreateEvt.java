package xyz.jecy.anox.api.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author dongkw
 * @Date 2020/9/7、9:05
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CapitalCreateEvt {
    private String id;
    private int amount;
}
