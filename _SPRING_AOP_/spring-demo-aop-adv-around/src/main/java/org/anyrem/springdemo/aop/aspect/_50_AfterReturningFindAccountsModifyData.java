package org.anyrem.springdemo.aop.aspect;

import org.anyrem.springdemo.aop.entity.Account;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Order(50)
@Component
public class _50_AfterReturningFindAccountsModifyData {

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


    @AfterReturning(pointcut = "org.anyrem.springdemo.aop.aspect.PointcutDeclarations.forDaoPackageNotGetterSetter())",
            returning = "result")
    public void convertAccountsToUpperCaseAdvice(List<Account> result) {
        System.out.println("ASPECT> executing @AfterReturning: MODIFY returned accounts:");

        for (Account account : result) {

            account.setName(
                    account.getName()
                            .toUpperCase()
            );
        }

    }


/*
    // public is optional, void is replaced with * = all return types
    @After("forDaoPackage()")
    public void AfterAddAccountAdvice() {
        System.out.println("ASPECT> executing @After advice on addAccount*()");
    }
    */
}
