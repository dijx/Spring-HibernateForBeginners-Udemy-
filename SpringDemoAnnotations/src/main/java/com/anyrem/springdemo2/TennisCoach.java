package com.anyrem.springdemo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//@Component("TennisCoach")
@Component
@Scope("prototype")
public class TennisCoach implements Coach {

    private FortuneService fortuneService;

    public TennisCoach() {
        System.out.println("calling tennisCoach no-arg constructor");
    }

    @Autowired
    public TennisCoach(@Qualifier("randomFortuneService") FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    @PostConstruct
    private void samplePostConstruct() {
        System.out.println("Post constuct method");
    }

    @PreDestroy
    private void samplePreDestoy() {
        System.out.println("Pre destroy method");
    }
}
