package com.anyrem.springdemo2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomFortuneService implements FortuneService {

    @Value("${randomFortuneFortunes}")
    private String[] randomFortunes;

    @Override
    public String getFortune() {
        return generateRandomFortune();
    }


    private String generateRandomFortune() {

        if (randomFortunes == null || randomFortunes.length == 0) {
            return "No fortune for you, sorry";
        }

        Random random = new Random();
        int r = random.nextInt(randomFortunes.length);

        return randomFortunes[r];
    }
}
