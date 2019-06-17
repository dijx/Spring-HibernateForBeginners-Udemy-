package com.anyrem.springdemo2;

import org.springframework.stereotype.Component;

@Component
public class UnhappyFortuneService implements FortuneService {

    @Override
    public String getFortune() {
        return "Break a neck, spine and lightspeed bareer";
    }
}
