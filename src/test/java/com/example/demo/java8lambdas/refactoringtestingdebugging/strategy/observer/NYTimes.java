package com.example.demo.java8lambdas.refactoringtestingdebugging.strategy.observer;

/**
 * @Package: com.example.demo.java8lambdas.refactoringtestingdebugging.strategy.observer
 * @Author:
 * @Email:
 * @CreateDate: 2019-05-15 11:08
 * @Description:
 */

/*
 * You can now declare different observers (here, the three newspapers) that produce a different
 * action for each different keyword contained in a tweet:
 * */
public class NYTimes implements Observer {
    @Override
    public void notify(String tweet) {
        if (tweet != null && tweet.contains("money")) {
            System.out.println("Breaking news in NY! " + tweet);
        }
    }
}
