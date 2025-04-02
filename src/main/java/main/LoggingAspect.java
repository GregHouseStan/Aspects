package main;

import model.Comment;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
@Order(1)
@Component
public class LoggingAspect {
    private LoggingAspect aspect;
    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

   /* public LoggingAspect(LoggingAspect aspect) {
        this.aspect = aspect;
    }*/


   /* @AfterReturning(value = "@annotation(ToLog)",
            returning = "returnedValue")
    public void log(Object returnedValue) {
        logger.info("Method executed and returned " + returnedValue);*/
    //THE ABOVE IS AN EXAMPLE, USING ANOTHER ASPECT ANNOTATION, I.E AFTER, AFTERTHROWING AND BEFORE.

@Around("@annotation(ToLog)")
public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
    logger.info("Logging Aspect: Calling the intercepted method");
    Object returnedValue = joinPoint.proceed();
    logger.info("Logging Aspect: Method executed and returned " +
            returnedValue);
    return returnedValue;
    //The above is implemented for Security Aspect, showing the aspect execution chain.

    /*String methodName = joinPoint.getSignature().getName();
    Object [] arguments = joinPoint.getArgs();

    logger.info("Method " + methodName +
            " with parameters " + Arrays.asList(arguments) +
            " will execute");

    Comment comment = new Comment();
    comment.setText("Some other text!");
    Object [] newArguments = {comment};

    Object returnedByMethod = joinPoint.proceed(newArguments);
    logger.info("Method executed and returned " + returnedByMethod);

    return "FAILED";*/


   /* logger.info("Method will execute");
    joinPoint.proceed();
    logger.info("Method executed");*/
}

}
