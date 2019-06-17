package com.anyrem.springdemo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BowlingCoach implements Coach {

    FortuneService fortuneService;

    @Override
    public String getDailyWorkout() {
        return "Bowling workout";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    @Autowired
    @Qualifier("happyFortuneService")
    public void setFortuneService(FortuneService fortuneService) {
        System.out.println("Setter: fortuneService@bowlingCoach");
        this.fortuneService = fortuneService;
    }
}
