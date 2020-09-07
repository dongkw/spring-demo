package xyz.jecy.anox.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.jecy.anox.domain.query.CapitalEntry;

import java.util.List;

/**
 * @Author dongkw
 * @Date 2020/9/7、10:21
 **/
@Repository
public interface CapitalEntityRepository extends JpaRepository<CapitalEntry,String> {

    CapitalEntry findOneByAxonCapitalId(String axonCapitalId);
}
