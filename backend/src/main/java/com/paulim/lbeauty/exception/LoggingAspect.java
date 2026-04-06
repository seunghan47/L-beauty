package com.paulim.lbeauty.exception;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("execution(* com.paulim.lbeauty.inventory.InventoryController.searchItems(..))")
    public void logBeforeSearch(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        logger.info("SEARCH INITIATED: Method [{}] called with term: {}",
                joinPoint.getSignature().getName(), Arrays.toString(args));
    }

    @AfterReturning(pointcut = "execution(* com.paulim.lbeauty.inventory.InventoryController.searchItems(..))", returning = "result")
    public void logAfterSearch(JoinPoint joinPoint, Object result) {
        logger.info("SEARCH COMPLETED: Method [{}] successfully returned data.",
                joinPoint.getSignature().getName());
    }
}