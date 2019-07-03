package org.anyrem.springdemo.aop.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    @Before("execution(public void addAccount())")
    public void deforeAddAddountAdvice() {
        System.out.println("ASPECT> executing @Before advice on addAccount()");
    }

    // public is optional, void is replaced with * - all return types
    @After("execution(* addAccount*())")
    public void AfterAddAccountAdvice() {
        System.out.println("ASPECT> executing @After advice on addAccount*()");
    }
}
