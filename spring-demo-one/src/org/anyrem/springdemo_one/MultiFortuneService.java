package org.anyrem.springdemo_one;

import java.util.Random;

public class MultiFortuneService implements FortuneService {

    private String[] multiFortune;

    public void setMultiFortune(String[] multiFortune) {
        this.multiFortune = multiFortune;
    }

    @Override
    public String getFortune() {

        if (multiFortune == null || multiFortune.length == 0) {
            return "No fortune for today :(";
        }
        int l = multiFortune.length;

        Random random = new Random();
        int n = random.nextInt(l);

        return multiFortune[n];
    }
}
