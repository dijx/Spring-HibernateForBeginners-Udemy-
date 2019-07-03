package org.anyrem.springdemo.aop;

import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService implements FortuneService {

    @Override
    public String getFortune() {
        return "Break a leg";
    }
}
