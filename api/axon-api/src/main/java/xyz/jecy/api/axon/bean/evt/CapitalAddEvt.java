package xyz.jecy.api.axon.bean.evt;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author dongkw
 * @Date 2020/9/7、9:39
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CapitalAddEvt {
    private String id;
    private int amount;
}
