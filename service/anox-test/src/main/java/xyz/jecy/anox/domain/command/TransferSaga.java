package xyz.jecy.anox.domain.command;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.modelling.saga.*;
import org.axonframework.spring.stereotype.Saga;
import org.springframework.beans.factory.annotation.Autowired;
import xyz.jecy.api.axon.bean.cmd.CapitalAddCmd;
import xyz.jecy.api.axon.bean.cmd.CapitalSubtractCmd;
import xyz.jecy.api.axon.bean.cmd.CapitalTransferAddCmd;
import xyz.jecy.api.axon.bean.cmd.CapitalTransferSubtractCmd;
import xyz.jecy.api.axon.bean.evt.*;

/**
 * @Author dongkw
 * @Date 2020/9/9、9:37
 **/
@Saga
@Slf4j
public class TransferSaga {

    @Autowired
    private CommandGateway commandGateway;
    @JsonProperty
    private String from;
    @JsonProperty
    private String to;
    @JsonProperty
    private int amount;
    @JsonProperty
    private String transferId;
    @JsonProperty
    private boolean add = false;
    @JsonProperty
    private boolean subtract = false;

    @StartSaga
    @SagaEventHandler(associationProperty = "transferId")
    public void handler(TransferEvt evt) {
        transferId = evt.getTransferId();
        log.info("sage开始：{}", transferId);
        from = evt.getFrom();
        to = evt.getTo();
        amount = evt.getAmount();

        SagaLifecycle.associateWith("id", from);
        SagaLifecycle.associateWith("id", to);
        commandGateway.send(new CapitalAddCmd(evt.getTo(), evt.getAmount()));

        commandGateway.send(new CapitalSubtractCmd(evt.getFrom(), evt.getAmount()));

        log.info("{}给{}转了{}钱", evt.getFrom(), evt.getTo(), evt.getAmount());
    }

    @SagaEventHandler(associationProperty = "id")
    public void handler(NotEnoughEvt evt) {
        log.info("没钱了：{}", evt);
        SagaLifecycle.associateWith("id", to);
        commandGateway.send(new CapitalSubtractCmd(to, amount));
    }

    @SagaEventHandler(associationProperty = "id")
    public void handler(CapitalSubtractEvt evt) {
        log.info("减完了：{}", evt);
        subtract = true;
        if (add) {
            SagaLifecycle.end();
            log.info("saga结束：{}", transferId);
        }
    }

    @SagaEventHandler(associationProperty = "id")
    public void handler(CapitalAddEvt evt) {
        log.info("加完了{}", evt);
        add = true;
        if (subtract) {
            SagaLifecycle.end();
            log.info("saga结束：{}", transferId);
        }
    }

}

