package com.example.demo.spring.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

/**
 * @package: com.example.demo.spring.aop
 * @author:
 * @email:
 * @createDate: 2019-06-03 17:20
 * @description:
 */
@Aspect
@Configuration
@Slf4j
public class UserAccessAspect {
    //What kind of method calls I would intercept
    //execution(* PACKAGE.*.*(..))
    //Weaving & Weaver
    @Before("execution(* com.example.demo.spring.aop.data.*.*(..))")
    public void before(JoinPoint joinPoint) {
        // Advice
        log.info(" Check for user access ");
        log.info(" Allowed execution for {}", joinPoint);
    }
}
