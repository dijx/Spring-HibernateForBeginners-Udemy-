package org.anyrem.springdemo.aop;

import org.anyrem.springdemo.aop.dao.AccountDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDao accountDao = annotationConfigApplicationContext.getBean("accountDao", AccountDao.class);

        accountDao.addAccount();
        accountDao.addAccount();
        accountDao.addAccount();

        annotationConfigApplicationContext.close();

    }
}
