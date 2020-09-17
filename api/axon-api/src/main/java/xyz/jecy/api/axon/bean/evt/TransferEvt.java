package xyz.jecy.api.axon.bean.evt;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

/**
 * @Author dongkw
 * @Date 2020/9/9、9:43
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransferEvt {
    private String transferId;
    private String from;
    private String to;
    private int amount;
}
