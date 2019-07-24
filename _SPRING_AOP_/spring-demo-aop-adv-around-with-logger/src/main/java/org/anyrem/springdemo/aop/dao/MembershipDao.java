package org.anyrem.springdemo.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDao {

    public void addAccount() {

        System.out.println(getClass() + ": adding a membership account");
    }

    public boolean addInvalidMember() {

        System.out.println(getClass() + ": adding an INVALID membership account");

        return true;
    }

}
