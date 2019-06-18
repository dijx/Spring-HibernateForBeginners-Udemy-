package com.anyrem.springdemo2;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");


        Coach theCoach = context.getBean("tennisCoach", Coach.class);
        Coach alfaCoach = context.getBean("tennisCoach", Coach.class);

        // true for singleton, false for prototype scope.
        boolean result = (theCoach == alfaCoach);

        System.out.println("Are coaches equal: " + result);

        System.out.println("theCoach = " + theCoach);
        System.out.println("alfaCoach: " + alfaCoach);

        context.close();

    }

}
