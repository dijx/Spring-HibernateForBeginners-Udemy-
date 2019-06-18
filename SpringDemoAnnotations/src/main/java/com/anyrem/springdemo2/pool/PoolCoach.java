package com.anyrem.springdemo2.pool;

import com.anyrem.springdemo2.Coach;
import com.anyrem.springdemo2.FortuneService;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class PoolCoach implements Coach {

    private FortuneService fortuneService;

    public PoolCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Practice some strong opening strikes";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    @PreDestroy
    @PostConstruct
    private void prepost() {
        System.out.println("prepost");
    }
}
