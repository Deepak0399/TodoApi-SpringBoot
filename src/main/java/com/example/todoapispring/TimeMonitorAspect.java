package com.example.todoapispring;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.After;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeMonitorAspect {
    @Around("@annotation(TimeMonitor)")
    public void logTime(ProceedingJoinPoint joinPoint) {
        long start = System.currentTimeMillis();//Start time of the code

        try {
            joinPoint.proceed();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }finally {
            long end = System.currentTimeMillis();//End time of the code
            long totalExecutionTime = end - start;
            System.out.println("Total time execution of the method is: " + totalExecutionTime +" ms...");
        }
    }
}
