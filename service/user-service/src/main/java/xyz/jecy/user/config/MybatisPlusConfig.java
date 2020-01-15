package xyz.jecy.user.config;

import com.fasterxml.jackson.databind.SerializationFeature;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author dkw[dongkewei@xinzhili.cn]
 * @data 2019/12/31 2:35 下午
 */
@Configuration
@MapperScan("xyz.jecy.user.mapper")
public class MybatisPlusConfig {

  @Bean
  public Jackson2ObjectMapperBuilderCustomizer customizer(){
    return builder -> builder.featuresToEnable(SerializationFeature.WRITE_ENUMS_USING_TO_STRING);
  }
}
