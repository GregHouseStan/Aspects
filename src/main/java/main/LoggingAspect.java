package main;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {
    private LoggingAspect aspect;
    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

   /* public LoggingAspect(LoggingAspect aspect) {
        this.aspect = aspect;
    }*/

@Around("execution(* services.*.*(..))")
public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
    String methodName = joinPoint.getSignature().getName();
    Object [] arguments = joinPoint.getArgs();

    logger.info("Method " + methodName +
            " with parameters " + Arrays.asList(arguments) +
            " will execute");
    Object returnedByMethod = joinPoint.proceed();
    logger.info("Method executed and returned " + returnedByMethod);
    return returnedByMethod;


   /* logger.info("Method will execute");
    joinPoint.proceed();
    logger.info("Method executed");*/
}

}
