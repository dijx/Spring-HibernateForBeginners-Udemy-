package org.anyrem.springdemo_one;

public class TrackCoach implements Coach {

    private FortuneService fortuneService;

    public TrackCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDayilyWorkout() {

        return "Run a hard 5k";
    }

    @Override
    public String getDayilyFortune() {
        return fortuneService.getFortune();
    }
}
