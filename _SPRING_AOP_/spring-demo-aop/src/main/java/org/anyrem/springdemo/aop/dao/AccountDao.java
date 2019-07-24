package org.anyrem.springdemo.aop.dao;

import org.anyrem.springdemo.aop.entity.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDao {

    public void addAccount() {
        System.out.println(getClass() + ": doing my db work - adding account");
    }

    public void addAccount(Account account) {

        System.out.println(getClass() + ": doing my db work - adding NAMED account OBJECT");
    }

    public void addAccount(Account account, boolean vipFlag) {

        System.out.println(getClass() + ": doing my db work - adding NAMED account OBJECT with vipFlag");
    }

    public void doWork() {
        System.out.println(getClass() + ": doWork is doing work");
    }
}
