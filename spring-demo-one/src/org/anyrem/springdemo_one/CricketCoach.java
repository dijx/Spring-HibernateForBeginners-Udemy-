package org.anyrem.springdemo_one;

public class CricketCoach implements Coach {

    private FortuneService fortuneService;
    private String emailAddress;
    private String team;


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
        System.out.println("Cricket coach: setter fortuneService");
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        System.out.println("Cricket coach: setter emailAddress");
        this.emailAddress = emailAddress;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        System.out.println("Cricket coach: setter team ");
        this.team = team;
    }


}
