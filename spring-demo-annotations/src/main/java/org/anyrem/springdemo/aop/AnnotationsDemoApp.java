package org.anyrem.springdemo.aop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationsDemoApp {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        Coach tennisCoach = context.getBean("tennisCoach", Coach.class);
        Coach bowlingCoach = context.getBean("bowlingCoach", BowlingCoach.class);
        Coach swimmingCoach = context.getBean("swimmingCoach", SwimmingCoach.class);

        System.out.println(bowlingCoach.getDailyWorkout());
        System.out.println(bowlingCoach.getDailyFortune());

        System.out.println(tennisCoach.getDailyWorkout());
        System.out.println(tennisCoach.getDailyFortune());

        System.out.println("---swimming");
        System.out.println(swimmingCoach.getDailyFortune());

        context.close();

    }

}
