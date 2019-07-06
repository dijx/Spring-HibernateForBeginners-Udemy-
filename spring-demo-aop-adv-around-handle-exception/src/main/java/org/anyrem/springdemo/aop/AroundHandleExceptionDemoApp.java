package org.anyrem.springdemo.aop;

import org.anyrem.springdemo.aop.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class AroundHandleExceptionDemoApp {


    private static final Logger myLogger =
            Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        TrafficFortuneService trafficFortuneService =
                context.getBean("trafficFortuneService", TrafficFortuneService.class);


        myLogger.info("AdoundDemoApp");

        Boolean tripWire = true;

        String fortune = trafficFortuneService.getFortune(tripWire);

        myLogger.info("fortune for today is: " + fortune);

        myLogger.info("END");


        context.close();

    }
}
