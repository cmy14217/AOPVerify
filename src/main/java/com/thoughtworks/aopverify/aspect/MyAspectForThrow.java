package com.thoughtworks.aopverify.aspect;

import com.thoughtworks.aopverify.repository.LoggerManager;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
public class MyAspectForThrow {

    @Autowired
    LoggerManager loggerManager;

    @Before(value = "@annotation(com.thoughtworks.aopverify.annotation.MySecondLogger)")
    public void verifyBefore(JoinPoint joinPoint){
        loggerManager.log("Before method " + joinPoint.getSignature().getName() + " is invoked at " + LocalDateTime.now());
    }

    @After(value = "@annotation(com.thoughtworks.aopverify.annotation.MySecondLogger)")
    public void verifyAfter(JoinPoint joinPoint){
        loggerManager.log("After method " + joinPoint.getSignature().getName() + " is invoked at " + LocalDateTime.now());
    }

    @AfterThrowing(value = "@annotation(com.thoughtworks.aopverify.annotation.MySecondLogger)")
    public void verifyAfterThrowing(JoinPoint joinPoint){
        loggerManager.log("After throwing exception of method " +
                joinPoint.getSignature().getName() + " is invoked at " + LocalDateTime.now());
    }

    @Around(value = "@annotation(com.thoughtworks.aopverify.annotation.MySecondLogger)")
    public void verifyAround(ProceedingJoinPoint joinPoint) throws Throwable {
        loggerManager.log("Around before proceed method " + joinPoint.getSignature().getName() + " is invoked at " + LocalDateTime.now());
        joinPoint.proceed();
        loggerManager.log("Around after proceed method " + joinPoint.getSignature().getName() + " is invoked at " + LocalDateTime.now());
    }

    @AfterReturning(value = "@annotation(com.thoughtworks.aopverify.annotation.MySecondLogger)")
    public void verifyAfterReturning(JoinPoint joinPoint){
        loggerManager.log("After returning method " + joinPoint.getSignature().getName() + " is invoked at " + LocalDateTime.now());
    }

}
