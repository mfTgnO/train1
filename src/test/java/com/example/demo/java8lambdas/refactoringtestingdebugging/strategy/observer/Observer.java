package com.example.demo.java8lambdas.refactoringtestingdebugging.strategy.observer;

/**
 * @Package: com.example.demo.java8lambdas.refactoringtestingdebugging.strategy.observer
 * @Author:
 * @Email:
 * @CreateDate: 2019-05-15 11:05
 * @Description:
 */

/*
 * First, you need an Observer interface that groups the different observers. It has just one method
 * called notify that will be called by the subject (Feed) when a new tweet is available:
 * */
public interface Observer {
    void notify(String tweet);
}
