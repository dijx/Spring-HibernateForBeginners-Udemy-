package org.anyrem.springdemo_one;

public class MyApp {

    public static void main(String[] args) {
//		Coach baseballCoach = new BaseballCoach();

        Coach myCoach = new TrackCoach(() -> "This coach is working in compatibility mode");

        System.out.println(myCoach.getDayilyWorkout());


    }

}
