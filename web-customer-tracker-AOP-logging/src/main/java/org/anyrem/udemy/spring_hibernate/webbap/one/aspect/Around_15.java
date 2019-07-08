package org.anyrem.udemy.spring_hibernate.webbap.one.aspect;

import org.anyrem.udemy.spring_hibernate.webbap.one.entity.Customer;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@Aspect
@Order(15)
public class Around_15 {

    private final static Logger logger = Logger.getLogger(Around_15.class.getName());


    @Around("org.anyrem.udemy.spring_hibernate.webbap.one.aspect.PointcutDeclarations.appFlow()")
    public Object notAllowRemigiuszAnyz(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        logger.info("\nCalled method: " + proceedingJoinPoint.getSignature().toShortString() + ", params:\n");

        Object result = proceedingJoinPoint.proceed();

        for (Object arg : proceedingJoinPoint.getArgs()) {
            System.out.println(arg.toString());
            if (arg instanceof Customer
                    && ((Customer) arg).getFirstName().equals("Remigiusz")
                    && ((Customer) arg).getLastName().equals("Anyz")
            ) {

                logger.warning("Can not add this user!");
                ((Customer) arg).setFirstName("NOT_ALLOWED");
                ((Customer) arg).setLastName("NOT_ALLOWED");
            }
        }

        return result;
    }


}
