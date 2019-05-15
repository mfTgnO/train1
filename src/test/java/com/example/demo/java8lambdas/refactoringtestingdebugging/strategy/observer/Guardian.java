package com.example.demo.java8lambdas.refactoringtestingdebugging.strategy.observer;

/**
 * @Package: com.example.demo.java8lambdas.refactoringtestingdebugging.strategy.observer
 * @Author:
 * @Email:
 * @CreateDate: 2019-05-15 11:09
 * @Description:
 */
public class Guardian implements Observer {

    @Override
    public void notify(String tweet) {
        if (tweet != null && tweet.contains("queen")) {
            System.out.println("Yet another news in London... " + tweet);
        }
    }
}
