package org.anyrem.springdemo.aop.aspect;

import org.anyrem.springdemo.aop.entity.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(60)
@Component
public class _60_AfterThrowing {

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


    @AfterThrowing(pointcut = "org.anyrem.springdemo.aop.aspect.PointcutDeclarations.forDaoPackageNotGetterSetter())",
            throwing = "exThrown")
    public void convertAccountsToUpperCaseAdvice(JoinPoint joinPoint, Throwable exThrown) {
        System.out.println("ASPECT> @AfterThrowing: exeption thrown by " + joinPoint.getSignature().toShortString());
        System.out.println(exThrown.getMessage());

    }
}
