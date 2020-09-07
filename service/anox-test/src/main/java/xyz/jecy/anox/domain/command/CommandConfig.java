package xyz.jecy.anox.domain.command;

import org.axonframework.common.caching.Cache;
import org.axonframework.common.caching.WeakReferenceCache;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.axonframework.modelling.command.Repository;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import xyz.jecy.anox.domain.command.model.Capital;

/**
 * @Author dongkw
 * @Date 2020/9/4、15:58
 **/
@Component
public class CommandConfig {
    @Bean
    public Repository<Capital> capitalRepository(EventStore eventStore, Cache cache) {
        return EventSourcingRepository.builder(Capital.class)
                .cache(cache)
                .eventStore(eventStore)
                .build();
    }

    @Bean
    public Cache cache() {
        return new WeakReferenceCache();
    }
}
