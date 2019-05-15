package com.example.demo.java8lambdas.refactoringtestingdebugging.strategy.chainofresponsibility;

/**
 * @Package: com.example.demo.java8lambdas.refactoringtestingdebugging.strategy.chainofresponsibility
 * @Author:
 * @Email:
 * @CreateDate: 2019-05-15 16:27
 * @Description:
 */
public class HeaderTextProcessing extends ProcessingObject<String> {
    @Override
    protected String handleWork(String input) {
        return "From Raoul, Mario and Alan: " + input;
    }
}
