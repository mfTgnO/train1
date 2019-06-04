package com.example.demo.spring.aop;

import org.aspectj.lang.annotation.Pointcut;

/**
 * @package: com.example.demo.spring.aop
 * @author:
 * @email:
 * @createDate: 2019-06-03 17:36
 * @description:
 */
public class CommonJoinPointConfig {
    @Pointcut("execution(* com.example.demo.spring.aop.data.*.*(..))")
    public void dataLayerExecution() {

    }

    @Pointcut("execution(* com.example.demo.spring.aop.business.*.*(..))")
    public void businessLayerExecution() {

    }
}
