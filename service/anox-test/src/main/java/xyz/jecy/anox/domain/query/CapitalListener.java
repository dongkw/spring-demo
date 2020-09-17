package xyz.jecy.anox.domain.query;

import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import xyz.jecy.anox.repository.CapitalEntityRepository;
import xyz.jecy.api.axon.bean.evt.CapitalAddEvt;
import xyz.jecy.api.axon.bean.evt.CapitalCreateEvt;
import xyz.jecy.api.axon.bean.evt.CapitalSubtractEvt;


/**
 * @Author dongkw
 * @Date 2020/9/7、10:20
 **/
@Component
@Slf4j
public class CapitalListener {

    @Autowired
    private CapitalEntityRepository capitalRepository;

    @EventHandler
    public void on(CapitalCreateEvt evt) {
        log.info("这边也加一条：{}",evt);
        capitalRepository.save(new CapitalEntry(evt.getId(), evt.getAmount()));
    }

    @EventHandler
    public void on(CapitalAddEvt evt) {
        CapitalEntry entry = capitalRepository.findOneByAxonCapitalId(evt.getId());
        log.info("这边改之前：{}",entry);
        entry.setBalance(entry.getBalance() + evt.getAmount());
        capitalRepository.save(entry);
        log.info("这边改之后：{}",entry);


    }
    @EventHandler
    public void on(CapitalSubtractEvt evt) {
        CapitalEntry entry = capitalRepository.findOneByAxonCapitalId(evt.getId());
        log.info("这边改之前：{}",entry);
        entry.setBalance(entry.getBalance() - evt.getAmount());
        capitalRepository.save(entry);
        log.info("这边改之后：{}",entry);


    }

}
