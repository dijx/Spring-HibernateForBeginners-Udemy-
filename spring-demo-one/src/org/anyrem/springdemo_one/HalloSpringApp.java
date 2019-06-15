package org.anyrem.springdemo_one;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HalloSpringApp {


    public static void main(String[] args) {

        //load Spring config
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        //load bean:
        Coach trackCoach = classPathXmlApplicationContext.getBean("trackCoach", Coach.class);
        Coach baseballCoach = classPathXmlApplicationContext.getBean("baseballCoach", Coach.class);
        Coach swimmingCoach = classPathXmlApplicationContext.getBean("swimmingCoach", Coach.class);

        System.out.println(trackCoach.getDayilyWorkout() + " " + trackCoach.getDayilyFortune());
        System.out.println(baseballCoach.getDayilyWorkout() + " " + trackCoach.getDayilyFortune());
        System.out.println(swimmingCoach.getDayilyWorkout() + " " + trackCoach.getDayilyFortune());

        classPathXmlApplicationContext.close();

    }
}
