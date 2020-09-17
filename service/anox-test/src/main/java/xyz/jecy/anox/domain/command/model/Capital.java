package xyz.jecy.anox.domain.command.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.eventhandling.gateway.EventGateway;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xyz.jecy.api.axon.bean.cmd.*;
import xyz.jecy.api.axon.bean.evt.*;


/**
 * @Author dongkw
 * @Date 2020/9/4、14:23
 **/
@Slf4j
@Aggregate
@NoArgsConstructor
@Getter
public class Capital {

    @AggregateIdentifier
    private String id;
    private int balance;


    @CommandHandler
    public Capital(CapitalCreatCmd cmd) {
        log.info("创建资金:{}", cmd);
        AggregateLifecycle.apply(new CapitalCreateEvt(cmd.getId(), cmd.getAmount()));
    }

    @CommandHandler
    public void handler(CapitalAddCmd cmd) {
        log.info("加钱cmd:{}", cmd);
        AggregateLifecycle.apply(new CapitalAddEvt(cmd.getId(), cmd.getAmount()));
    }

    @CommandHandler
    public void handler(CapitalSubtractCmd cmd) {
        log.info("一共有{},减{},{}",balance,cmd.getAmount(),cmd);
        if (balance < cmd.getAmount()) {
            AggregateLifecycle.apply(new NotEnoughEvt(id));
        } else {
            AggregateLifecycle.apply(new CapitalSubtractEvt(cmd.getId(), cmd.getAmount()));
        }
    }

    @EventSourcingHandler
    public void on(CapitalSubtractEvt evt) {
        log.info("减钱evt：{}", evt);
        balance -= evt.getAmount();
    }

    @EventSourcingHandler
    public void on(CapitalCreateEvt evt) {
        log.info("加个人：{}", evt);
        id = evt.getId();
        balance = evt.getAmount();
    }

    @EventSourcingHandler
    public void on(CapitalAddEvt evt) {
        log.info("加钱evt：{}", evt);
        balance += evt.getAmount();
    }
}


