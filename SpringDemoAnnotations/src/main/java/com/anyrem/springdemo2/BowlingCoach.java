package com.anyrem.springdemo2;

import org.springframework.stereotype.Component;

@Component
public class BowlingCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Bowling workout";
    }

    @Override
    public String getDailyFortune() {
        return new HappyFortuneService().getFortune();
    }
}
