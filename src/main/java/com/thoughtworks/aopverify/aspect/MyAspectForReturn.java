package com.thoughtworks.aopverify.aspect;

import com.thoughtworks.aopverify.repository.LoggerManager;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
public class MyAspectForReturn {

    @Autowired
    LoggerManager loggerManager;

    @After(value = "@annotation(com.thoughtworks.aopverify.annotation.MyThirdLogger)")
    public void verifyAfter(JoinPoint joinPoint){
        loggerManager.log("After method " + joinPoint.getSignature().getName() + " is invoked at " + LocalDateTime.now());
    }

    @AfterReturning(value = "@annotation(com.thoughtworks.aopverify.annotation.MyThirdLogger)")
    public void verifyAfterReturning(JoinPoint joinPoint){
        loggerManager.log("After returning method " + joinPoint.getSignature().getName() + " is invoked at " + LocalDateTime.now());
    }

    @Around(value = "@annotation(com.thoughtworks.aopverify.annotation.MyThirdLogger)")
    public Object verifyAround(ProceedingJoinPoint joinPoint) throws Throwable {
        loggerManager.log("Around before proceed method " + joinPoint.getSignature().getName() + " is invoked at " + LocalDateTime.now());
        Object data= joinPoint.proceed();
        loggerManager.log("Around after proceed method " + joinPoint.getSignature().getName() + " is invoked at " + LocalDateTime.now());
        return data;
    }
}
