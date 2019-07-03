package org.anyrem.springdemo.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDao {

    public void addAccount() {
        System.out.println(getClass() + ": doing my db work - adding account");
    }
}
