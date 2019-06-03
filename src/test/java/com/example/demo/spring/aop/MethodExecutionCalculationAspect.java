package com.example.demo.spring.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

/**
 * @package: com.example.demo.spring.aop
 * @author:
 * @email:
 * @createDate: 2019-06-03 17:33
 * @description:
 */
@Aspect
@Configuration
@Slf4j
public class MethodExecutionCalculationAspect {
    @Around("@annotation(com.example.demo.spring.aop.TrackTime)")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        joinPoint.proceed();

        long timeTaken = System.currentTimeMillis() - startTime;
        log.info("Time Taken by {} is {}", joinPoint, timeTaken);
    }
}
