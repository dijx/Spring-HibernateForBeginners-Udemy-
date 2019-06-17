package org.anyrem.springdemo_one;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

    public static void main(String[] args) {

        //Scope demo

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("beanScope_applicationContext.xml");

        Coach theCoach = context.getBean("baseballCoach", Coach.class);
        Coach alfaCoach = context.getBean("baseballCoach", Coach.class);

        //are equals as singleton and as prototypes -- tests
        boolean result = (theCoach == alfaCoach);
        System.out.println("are equals: " + result);
        System.out.println("memoryAddress for theCoach: " + theCoach);
        System.out.println("memoryAddress for alfaCoach: " + alfaCoach);


        //Lifecycle demo

        ClassPathXmlApplicationContext contextL =
                new ClassPathXmlApplicationContext("beanLifecycle_applicationContext.xml");

        Coach lifeCoach = contextL.getBean("baseballCoach", Coach.class);
        lifeCoach.getDayilyFortune();

        contextL.close();
        context.close();

    }
}
