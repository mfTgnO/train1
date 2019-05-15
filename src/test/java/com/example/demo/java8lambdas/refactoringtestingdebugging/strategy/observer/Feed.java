package com.example.demo.java8lambdas.refactoringtestingdebugging.strategy.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Package: com.example.demo.java8lambdas.refactoringtestingdebugging.strategy.observer
 * @Author:
 * @Email:
 * @CreateDate: 2019-05-15 15:58
 * @Description:
 */
/*
 * The subject can register a new observer using the registerObserver method and notify his
 * observers of a tweet with the notifyObservers method. Let’s go ahead and implement the Feed
 * class:
 * */
public class Feed implements Subject {
    private final List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void notifyObservers(String tweet) {
        this.observers.forEach(o -> o.notify(tweet));
    }
}
