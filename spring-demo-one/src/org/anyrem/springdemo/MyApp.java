package org.anyrem.springdemo;

public class MyApp {

    public static void main(String[] args) {
//		Coach baseballCoach = new BaseballCoach();
        Coach myCoach = new TrackCoach();

        System.out.println(myCoach.getDayilyWorkout());


    }

}
