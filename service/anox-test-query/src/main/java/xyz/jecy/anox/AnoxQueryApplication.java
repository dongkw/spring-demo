package xyz.jecy.anox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author dkw[dongkewei@xinzhili.cn]
 * @data 2019/12/5 4:27 下午
 */

@SpringBootApplication
@EnableDiscoveryClient
public class AnoxQueryApplication {

  public static void main(String[] args) {
    SpringApplication.run(AnoxQueryApplication.class, args);
  }

}
