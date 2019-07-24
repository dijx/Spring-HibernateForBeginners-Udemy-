package org.anyrem.springdemo.aop.dao;

import org.anyrem.springdemo.aop.entity.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDao {

    private String name;
    private String serviceCode;


    public String getName() {

        System.out.println("AccountDao = getName called");
        return name;
    }

    public void setName(String name) {

        System.out.println("AccountDao = setName called");
        this.name = name;
    }

    public String getServiceCode() {

        System.out.println("AccountDao = getServiceCode called");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {

        System.out.println("AccountDao = setServiceCode called");
        this.serviceCode = serviceCode;
    }


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
