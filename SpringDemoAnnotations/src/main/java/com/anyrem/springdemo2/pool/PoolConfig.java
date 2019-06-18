package com.anyrem.springdemo2.pool;


import com.anyrem.springdemo2.Coach;
import com.anyrem.springdemo2.FortuneService;
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
