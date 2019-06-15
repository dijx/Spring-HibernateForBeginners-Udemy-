package org.anyrem.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HalloSpringApp {


    public static void main(String[] args) {

        //load Spring config
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        //load bean:
        Coach trackCoach = classPathXmlApplicationContext.getBean("trackCoach", Coach.class);
        Coach baseballCoach = classPathXmlApplicationContext.getBean("baseballCoach", Coach.class);
        Coach swimmingCoach = classPathXmlApplicationContext.getBean("swimmingCoach", Coach.class);

        System.out.println(trackCoach.getDayilyWorkout());
        System.out.println(baseballCoach.getDayilyWorkout());
        System.out.println(swimmingCoach.getDayilyWorkout());

        classPathXmlApplicationContext.close();

    }
}
