package org.anyrem.springdemo_one;

public class SwimmingCoach implements Coach {


    private FortuneService fortuneService;

    public SwimmingCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDayilyWorkout() {

        return "Swim 5 pools and than do some diving";
    }

    @Override
    public String getDayilyFortune() {
        return fortuneService.getFortune();
    }

}
