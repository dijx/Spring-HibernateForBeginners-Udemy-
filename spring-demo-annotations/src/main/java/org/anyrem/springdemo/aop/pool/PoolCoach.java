package org.anyrem.springdemo.aop.pool;

import org.anyrem.springdemo.aop.Coach;
import org.anyrem.springdemo.aop.FortuneService;

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
