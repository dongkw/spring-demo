package xyz.jecy.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author dkw[dongkewei@xinzhili.cn]
 * @data 2019/12/5 4:27 下午
 */
@SpringBootApplication
@EnableFeignClients(basePackages = "xyz.jecy.*.client")
@EnableDiscoveryClient
public class UserApplication {

  public static void main(String[] args) {
    SpringApplication.run(UserApplication.class, args);
  }

}
