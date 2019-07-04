package org.anyrem.springdemo.aop;

import org.anyrem.springdemo.aop.dao.AccountDao;
import org.anyrem.springdemo.aop.dao.MembershipDao;
import org.anyrem.springdemo.aop.entity.Account;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDao accountDao = context.getBean("accountDao", AccountDao.class);
        MembershipDao membershipDao = context.getBean("membershipDao", MembershipDao.class);

        accountDao.addAccount();

        membershipDao.addAccount();

        membershipDao.addInvalidMember();

        accountDao.addAccount(new Account());

        accountDao.addAccount(new Account(), true);

        accountDao.doWork();


        context.close();

    }
}
