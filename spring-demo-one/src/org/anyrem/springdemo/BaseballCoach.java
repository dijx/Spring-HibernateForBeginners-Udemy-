package org.anyrem.springdemo;

public class BaseballCoach implements Coach {

    @Override
    public String getDayilyWorkout() {
        return "Spend 30 minutes on batting practice";
    }
}
