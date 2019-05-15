package com.example.demo.java8lambdas.refactoringtestingdebugging.strategy.observer;

/**
 * @Package: com.example.demo.java8lambdas.refactoringtestingdebugging.strategy.observer
 * @Author:
 * @Email:
 * @CreateDate: 2019-05-15 15:57
 * @Description:
 */
/*
 * You’re still missing the crucial part: the subject! Let’s define an interface for him:
 * */
public interface Subject {
    void registerObserver(Observer observer);

    void notifyObservers(String tweet);
}
