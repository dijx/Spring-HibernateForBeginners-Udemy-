package org.anyrem.springdemo.aop;

import org.anyrem.springdemo.aop.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AroundDemoApp {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        TrafficFortuneService trafficFortuneService =
                context.getBean("trafficFortuneService", TrafficFortuneService.class);


        System.out.println("AdoundDemoApp");

        System.out.println("fortune for today is: " + trafficFortuneService.getFortune());

        System.out.println("END");


        context.close();

    }
}
