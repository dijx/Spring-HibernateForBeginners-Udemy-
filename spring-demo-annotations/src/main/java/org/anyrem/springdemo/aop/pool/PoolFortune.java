package org.anyrem.springdemo.aop.pool;

import org.anyrem.springdemo.aop.FortuneService;

public class PoolFortune implements FortuneService {

    @Override
    public String getFortune() {
        return "Pool my finger :)))";
    }
}
