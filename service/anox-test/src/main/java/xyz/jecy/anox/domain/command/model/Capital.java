package xyz.jecy.anox.domain.command.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;
import xyz.jecy.anox.api.bean.CapitalAddCmd;
import xyz.jecy.anox.api.bean.CapitalAddEvt;
import xyz.jecy.anox.api.bean.CapitalCreatCmd;
import xyz.jecy.anox.api.bean.CapitalCreateEvt;


import static org.axonframework.modelling.command.AggregateLifecycle.apply;


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
        apply(new CapitalCreateEvt(cmd.getId(), cmd.getAmount()));
    }

    @CommandHandler
    public void handler(CapitalAddCmd cmd) {
        log.info("加钱cmd:{}", cmd);
        apply(new CapitalAddEvt(cmd.getId(), cmd.getAmount()));
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


