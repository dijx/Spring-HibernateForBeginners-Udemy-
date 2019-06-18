package com.anyrem.springdemo2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SportConfig.class);

        SnookerCoach snookerCoach = context.getBean("snookerCoach", SnookerCoach.class);

        System.out.println("-------snooker");
        System.out.println(snookerCoach.getDailyWorkout());
        System.out.println(snookerCoach.getDailyFortune());
        System.out.println(snookerCoach.getEmailAddress());
        System.out.println(snookerCoach.getTeam());


        context.close();

    }

}
