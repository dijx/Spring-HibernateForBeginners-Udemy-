package com.anyrem.springdemo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SwimmingCoach implements Coach {

    @Autowired
    private FortuneService fortuneService;

    @Override
    public String getDailyWorkout() {
        return "Swim hard to the New Zealand";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
