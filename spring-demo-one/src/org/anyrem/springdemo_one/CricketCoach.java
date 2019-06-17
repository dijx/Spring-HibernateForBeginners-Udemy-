package org.anyrem.springdemo_one;

public class CricketCoach implements Coach {


    private FortuneService fortuneService;

    public CricketCoach() {
        System.out.println("Cricket coach: no arg constructor");
    }

    @Override
    public String getDayilyWorkout() {
        return "bate some balls?";
    }

    @Override
    public String getDayilyFortune() {
        return fortuneService.getFortune();
    }

    public void setFortuneService(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
        System.out.println("Cricket coach: setter");
    }
}
