package xyz.jecy.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import xyz.jecy.auth.service.UserAuthenticationProvider2;
import xyz.jecy.auth.service.UserAuthenticationProvider3;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthenticationProvider userAuthenticationProvider;
    @Autowired
    private UserAuthenticationProvider2 userAuthenticationProvider2;
    @Autowired
    private UserAuthenticationProvider3 userAuthenticationProvider3;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers("/oauth/**", "/login/**", "/logout").permitAll()
            .anyRequest().authenticated()   // 其他地址的访问均需验证权限
            .and()
            .formLogin()
            .and()
            .logout().logoutSuccessUrl("/");
    }
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/assets/**");
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
      //在token中加入自定义的字段和角色
        auth.authenticationProvider(userAuthenticationProvider)
            .authenticationProvider(userAuthenticationProvider2)
            .authenticationProvider(userAuthenticationProvider3)
            .inMemoryAuthentication();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
    