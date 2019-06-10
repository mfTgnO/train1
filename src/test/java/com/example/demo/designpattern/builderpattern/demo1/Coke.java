package com.example.demo.designpattern.builderpattern.demo1;

/**
 * @package: com.example.demo.designpattern.builderpattern.demo1
 * @author:
 * @email:
 * @createDate: 2019-06-10 18:08
 * @description:
 */
public class Coke extends ColdDrink {
    @Override
    public String name() {
        return "Coke";
    }

    @Override
    public float price() {
        return 30.0f;
    }
}
