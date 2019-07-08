package org.anyrem.udemy.spring_hibernate.webbap.one.aspect;

import org.aspectj.lang.annotation.Pointcut;


public class PointcutDeclarations {

    @Pointcut("execution(* org.anyrem.udemy.spring_hibernate.webbap.one.service.*.*(..))")
    void forServicePackage() {
    }

    @Pointcut("execution(* org.anyrem.udemy.spring_hibernate.webbap.one.dao.*.*(..))")
    void forDaoPackage() {
    }

    @Pointcut("execution(* org.anyrem.udemy.spring_hibernate.webbap.one.controller.*.*(..))")
    void forControllerPackage() {
    }

    @Pointcut("(forServicePackage() || forDaoPackage() || forControllerPackage())")
    void appFlow() {
    }


}
