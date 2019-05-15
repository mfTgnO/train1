package com.example.demo.java8lambdas.refactoringtestingdebugging.strategy.strategy;

/**
 * @Package: com.example.demo.java8lambdas.refactoringtestingdebugging.strategy
 * @Author:
 * @Email:
 * @CreateDate: 2019-05-14 17:38
 * @Description:
 */
public class IsAllLowerCase implements ValidationStrategy {
    @Override
    public boolean execute(String s) {
        return s.matches("[a-z]+");
    }
}
