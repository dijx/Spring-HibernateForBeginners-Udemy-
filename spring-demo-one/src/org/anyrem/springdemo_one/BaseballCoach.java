package org.anyrem.springdemo_one;

public class BaseballCoach implements Coach {

    private FortuneService fortuneService;

    public BaseballCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDayilyWorkout() {
        return "Spend 30 minutes on batting practice";
    }

    @Override
    public String getDayilyFortune() {
        return fortuneService.getFortune();
    }


    private void sampleInit() {
        System.out.println("Sample init");
    }

    private void sampleDestroy() {
        System.out.println("Sample destroy");
    }

}
