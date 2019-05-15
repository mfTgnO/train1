package com.example.demo.java8lambdas.refactoringtestingdebugging.strategy.strategy;

/**
 * @Package: com.example.demo.java8lambdas.refactoringtestingdebugging.strategy
 * @Author:
 * @Email:
 * @CreateDate: 2019-05-14 17:39
 * @Description:
 */
public class IsNumeric implements ValidationStrategy {
    @Override
    public boolean execute(String s) {
        return s.matches("\\d+");
    }
}
