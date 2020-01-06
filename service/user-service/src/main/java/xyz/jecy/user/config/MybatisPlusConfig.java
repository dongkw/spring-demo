package xyz.jecy.user.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author dkw[dongkewei@xinzhili.cn]
 * @data 2019/12/31 2:35 下午
 */
@Configuration
@MapperScan("com.baomidou.mybatisplus.samples.quickstart.mapper")
public class MybatisPlusConfig {

}
