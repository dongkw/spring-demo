package xyz.jecy.api.axon.bean.cmd;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

/**
 * @Author dongkw
 * @Date 2020/9/7、9:38
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CapitalTransferSubtractCmd {
    @TargetAggregateIdentifier
    private String id;
    private String transferId;
    private int amount;
}
