package com.example.demo.spring.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

/**
 * @package: com.example.demo.spring.aop
 * @author:
 * @email:
 * @createDate: 2019-06-03 17:25
 * @description:
 */
@Aspect
@Configuration
@Slf4j
public class AfterAopAspect {
    @AfterReturning(value = "execution(* com.example.demo.spring.aop.business.*.*(..))", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        log.info("{} returned with value {}", joinPoint, result);
    }

    @After(value = "execution(* com.example.demo.spring.aop.business.*.*(..))")
    public void after(JoinPoint joinPoint) {
        log.info("after execution of {}", joinPoint);
    }
}
