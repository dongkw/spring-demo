package xyz.jecy.anox.domain.command.model;

import io.lettuce.core.dynamic.annotation.Command;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventhandling.gateway.EventGateway;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xyz.jecy.api.axon.bean.cmd.TransferCmd;
import xyz.jecy.api.axon.bean.evt.TransferEvt;



/**
 * @Author dongkw
 * @Date 2020/9/9、11:21
 **/
@Aggregate
public class Transfer {

    @AggregateIdentifier
    private String transferId;
    private String from;
    private String to;
    private int amount;


    public Transfer() {
    }

    @CommandHandler
    public Transfer(TransferCmd cmd){
        AggregateLifecycle.apply(new TransferEvt(cmd.getTransferId(), cmd.getFrom(), cmd.getTo(), cmd.getAmount()));
    }



    @EventSourcingHandler
    public void on(TransferEvt evt){
        this.transferId=evt.getTransferId();
        this.from=evt.getFrom();
        this.to=evt.getTo();
        this.amount=evt.getAmount();
    }


}
