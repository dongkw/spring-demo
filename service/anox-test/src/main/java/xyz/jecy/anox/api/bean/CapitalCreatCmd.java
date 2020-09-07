package xyz.jecy.anox.api.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

/**
 * @Author dongkw
 * @Date 2020/9/4、17:41
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CapitalCreatCmd {
    @TargetAggregateIdentifier
    private String id;
    private int amount;
}
