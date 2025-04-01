package main;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
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
public void log(ProceedingJoinPoint joinPoint) throws Throwable {
    logger.info("Method will execute");
    joinPoint.proceed();
    logger.info("Method executed");
}

}
