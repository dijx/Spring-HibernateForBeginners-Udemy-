package org.anyrem.springdemo.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("com.anyrem.springdemo2")
@PropertySource("classpath:sport.properties")
public class SportConfig {

    @Bean
    public FortuneService randomFortuneService() {
        return new RandomFortuneService();
    }

    @Bean
    public SnookerCoach snookerCoach() {
        return new SnookerCoach(randomFortuneService());
    }


}
