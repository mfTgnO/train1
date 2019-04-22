package com.example.demo.foundation.generics;

public class IntegerConsumer implements Consumer<Integer> {
    @Override
    public void consumer(Integer parameter) {
        System.out.println(parameter);
    }
}
