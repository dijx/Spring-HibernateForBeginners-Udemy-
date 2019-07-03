package org.anyrem.springdemo.aop.pool;

import org.anyrem.springdemo.aop.Coach;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PoolDemoApp {

    private static AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(PoolConfig.class);

    public static void main(String[] args) {

        Coach poolCoach = context.getBean("poolCoach", Coach.class);

        System.out.println(poolCoach.getDailyFortune());
        System.out.println(poolCoach.getDailyWorkout());

        context.close();

    }

}
