package com.anyrem.springdemo2;

import org.springframework.beans.factory.annotation.Value;


public class SnookerCoach implements Coach {

    //    @Autowired
//    @Qualifier("randomFortuneService")
    private FortuneService fortuneService;

    @Value("${snookerCoachEmailAddress}")
    private String team;

    @Value("${snookerCoachTeam}")
    private String emailAddress;

    public SnookerCoach() {
        System.out.println("SnookerCoach: no-arg constuctor called");
    }

    public SnookerCoach(FortuneService fortuneService) {
        System.out.println("snookerCoach: fortuneService-arg constuctor called");
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Practice some snooking";
    }

    @Override
    public String getDailyFortune() {
        return this.fortuneService.getFortune();
    }

    public String getTeam() {
        return team;
    }

    public String getEmailAddress() {
        return emailAddress;
    }
}
