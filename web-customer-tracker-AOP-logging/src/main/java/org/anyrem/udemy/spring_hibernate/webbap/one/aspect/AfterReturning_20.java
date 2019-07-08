package org.anyrem.udemy.spring_hibernate.webbap.one.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@Aspect
@Order(20)
public class AfterReturning_20 {

    private final static Logger logger = Logger.getLogger(AfterReturning_20.class.getName());


    @AfterReturning(
            pointcut = "org.anyrem.udemy.spring_hibernate.webbap.one.aspect.PointcutDeclarations.appFlow()",
            returning = "result")
    public void appFlow(JoinPoint joinPoint, Object result) {

        logger.info("\nCalled method: " + joinPoint.getSignature().toShortString() + ", params:\n");
        for (Object arg : joinPoint.getArgs()) {
            try {
                logger.info(arg.toString());
            } catch (Exception e) {
                logger.info(e.getMessage());
            }
        }
        try {
            logger.info(result.toString());
        } catch (Exception e) {
            logger.info(e.getMessage());
        }

    }


}
