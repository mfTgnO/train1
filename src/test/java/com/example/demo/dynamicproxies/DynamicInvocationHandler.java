package com.example.demo.dynamicproxies;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @package: com.example.demo.dynamicproxies
 * @author:
 * @email:
 * @createDate: 2019-06-15 14:04
 * @description:
 */
@Slf4j
public class DynamicInvocationHandler implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log.info("Invoked method: {}", method.getName());
        return 42;
    }
}
