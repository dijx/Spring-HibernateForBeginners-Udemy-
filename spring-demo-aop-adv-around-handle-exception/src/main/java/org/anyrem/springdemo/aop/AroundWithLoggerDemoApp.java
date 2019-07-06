package org.anyrem.springdemo.aop;

import org.anyrem.springdemo.aop.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class AroundWithLoggerDemoApp {


    private static final Logger myLogger =
            Logger.getLogger(AroundWithLoggerDemoApp.class.getName());

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        TrafficFortuneService trafficFortuneService =
                context.getBean("trafficFortuneService", TrafficFortuneService.class);


        myLogger.info("AdoundDemoApp");

        myLogger.info("fortune for today is: " + trafficFortuneService.getFortune());

        myLogger.info("END");


        context.close();

    }
}
