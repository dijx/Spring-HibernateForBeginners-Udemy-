package org.anyrem.springdemo.annotations.pool;

import org.anyrem.springdemo.annotations.FortuneService;

public class PoolFortune implements FortuneService {

    @Override
    public String getFortune() {
        return "Pool my finger :)))";
    }
}
