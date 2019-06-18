package com.anyrem.springdemo2.pool;

import com.anyrem.springdemo2.FortuneService;

public class PoolFortune implements FortuneService {

    @Override
    public String getFortune() {
        return "Pool my finger :)))";
    }
}
