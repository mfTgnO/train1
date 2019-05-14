package com.example.demo.java8lambdas.refactoringtestingdebugging.strategy;

import org.junit.Test;

/**
 * @Package: com.example.demo.java8lambdas.refactoringtestingdebugging.strategy
 * @Author:
 * @Email:
 * @CreateDate: 2019-05-14 17:40
 * @Description:
 */
public class Validator {
    private final ValidationStrategy strategy;

    public Validator(ValidationStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean validate(String s) {
        return strategy.execute(s);
    }
}
