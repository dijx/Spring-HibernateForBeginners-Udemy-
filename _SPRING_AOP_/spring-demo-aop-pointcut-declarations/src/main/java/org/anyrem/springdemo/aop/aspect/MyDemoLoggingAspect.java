package org.anyrem.springdemo.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    //@Before("execution(public void org.anyrem.springdemo.aop.dao.AccountDao.addAccount())")
    //@Before("execution(void add*())")
//    @Before("execution(* add*())")

    // FQCN must be used when indicating parameter's class.
//    @Before("execution(* add*(org.anyrem.springdemo.aop.entity.Account))")
//    @Before("execution(* add*(org.anyrem.springdemo.aop.entity.Account, boolean))")
//    @Before("execution(* add*(org.anyrem.springdemo.aop.entity.Account, ..))") //named param + one or more params
//    @Before("execution(* add*(..))") //one or more params
//    @Before("execution(* add*(*, *))")
//    @Before("execution(* org.anyrem.springdemo.aop.dao.MembershipDao.*(..))")
//    @Before("execution(* org.anyrem.springdemo.aop.dao.AccountDao.do*(..))")
//    @Before("execution(* org.anyrem.springdemo.aop.dao.AccountDao.do*(*))")


    @Pointcut("execution(* org.anyrem.springdemo.aop.dao.*.*(..))")
    private void forDaoPackage() {
    }

    @Pointcut("execution(* get*())")
    private void getter() {
    }

    @Pointcut("execution(* set*())")
    private void setter() {
    }

    @Pointcut("forDaoPackage() && !(getter() || setter() )")
    private void forDaoPackageNotGetterSetter() {
    }


    @Before("forDaoPackageNotGetterSetter()")
    public void beforeAddAddountAdvice() {
        System.out.println("ASPECT> executing @Before advice on addAccount()");
    }


/*
    // public is optional, void is replaced with * = all return types
    @After("forDaoPackage()")
    public void AfterAddAccountAdvice() {
        System.out.println("ASPECT> executing @After advice on addAccount*()");
    }
    */
}
