package org.anyrem.udemy.spring_hibernate.webbap.one.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@Aspect
@Order(10)
public class Before_10 {

    private final static Logger logger = Logger.getLogger(Before_10.class.getName());


    @Before("org.anyrem.udemy.spring_hibernate.webbap.one.aspect.PointcutDeclarations.appFlow()")
    public void appFlow(JoinPoint joinPoint) {

        logger.info("\nCalled method: " + joinPoint.getSignature().toShortString() + ", params:\n");
        for (Object arg : joinPoint.getArgs()) {
            System.out.println(arg.toString());
        }
    }


}
