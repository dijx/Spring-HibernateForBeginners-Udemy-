package org.anyrem.springdemo.aop.service;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@Component
public class TrafficFortuneService {


    private final static String fortune = "Expect heavy traffic this morning";


    public String getFortune() {

        //simulate a delay
        try {

            TimeUnit.SECONDS.sleep(5);

        } catch (InterruptedException e) {

            e.printStackTrace();
        }

        return fortune;
    }

    public String getFortune(Boolean tripWire) {


        if (tripWire) {

            throw (new RuntimeException("Stepped on tripwire"));

        } else {

            return getFortune();
        }
    }


}
