package org.anyrem.springdemo.annotations.pool;


import org.anyrem.springdemo.annotations.Coach;
import org.anyrem.springdemo.annotations.FortuneService;
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
