package org.anyrem.springdemo.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Order(80)
@Component
public class _80_Around_trafficFortuneService {

    private static final Logger myLogger =
            Logger.getLogger(_80_Around_trafficFortuneService.class.getName());

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


    @Around("org.anyrem.springdemo.aop.aspect.PointcutDeclarations.forTrafficGetFortune()")
    public Object aroundGetFortune(
            ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        myLogger.info("ASPECT> executing @Around advice");
        myLogger.info("on method: " + proceedingJoinPoint.getSignature().toShortString());

        long begin = System.currentTimeMillis();

        Object result = null;

        try {

            result = proceedingJoinPoint.proceed();

        } catch (Exception e) {


            myLogger.warning(e.getMessage());

            result = "Exception handled by AOP @Around";

            //throw e;

        }

        long end = System.currentTimeMillis();

        long duration = end - begin;

        myLogger.info("Duration was: " + (duration / 1000.0) + " seconds");

        return result;

    }


}
