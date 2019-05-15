package com.example.demo.java8lambdas.refactoringtestingdebugging.strategy.chainofresponsibility;

/**
 * @Package: com.example.demo.java8lambdas.refactoringtestingdebugging.strategy.chainofresponsibility
 * @Author:
 * @Email:
 * @CreateDate: 2019-05-15 16:28
 * @Description:
 */
public class SpellCheckerProcessing extends ProcessingObject<String> {
    @Override
    protected String handleWork(String input) {
        // Oops,we forgot the 'm' in "lambda"!
        return input.replaceAll("labda", "lambda");
    }
}
