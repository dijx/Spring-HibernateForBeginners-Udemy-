package org.anyrem.springdemo.aop.aspect;

import org.aspectj.lang.annotation.Pointcut;


public class PointcutDeclarations {

    @Pointcut("execution(* org.anyrem.springdemo.aop.dao.*.*(..))")
    void forDaoPackage() {
    }

    @Pointcut("execution(* org.anyrem.springdemo.aop.service.TrafficFortuneService.getFortune(..))")
    void forTrafficGetFortune() {
    }

    @Pointcut("execution(* get*(..))")
    void getter() {
    }

    @Pointcut("execution(* set*(..))")
    void setter() {
    }

    @Pointcut("forDaoPackage() && !(getter() || setter() )")
    void forDaoPackageNotGetterSetter() {
    }


}
