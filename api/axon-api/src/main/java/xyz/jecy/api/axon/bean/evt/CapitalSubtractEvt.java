package xyz.jecy.api.axon.bean.evt;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author dongkw
 * @Date 2020/9/9、9:53
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CapitalSubtractEvt {
    private String id;
    private int amount;

}
