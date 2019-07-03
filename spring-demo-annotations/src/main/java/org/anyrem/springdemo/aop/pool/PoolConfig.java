package org.anyrem.springdemo.aop.pool;


import org.anyrem.springdemo.aop.Coach;
import org.anyrem.springdemo.aop.FortuneService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PoolConfig {

    @Bean
    public FortuneService poolFortune() {
        return new PoolFortune();
    }

    @Bean
//    @Scope("prototype")
    public Coach poolCoach() {
        return new PoolCoach(poolFortune());
    }
}
