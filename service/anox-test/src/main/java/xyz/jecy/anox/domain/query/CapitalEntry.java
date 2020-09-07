package xyz.jecy.anox.domain.query;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @Author dongkw
 * @Date 2020/9/7、10:17
 **/
@Entity
@Data
@NoArgsConstructor
public class CapitalEntry {
    @Id
    @GeneratedValue
    private long id;
    private String axonCapitalId;
    private int balance;

    public CapitalEntry(String axonCapitalId, int balance) {
        this.axonCapitalId = axonCapitalId;
        this.balance = balance;
    }
}
