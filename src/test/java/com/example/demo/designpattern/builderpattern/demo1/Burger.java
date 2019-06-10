package com.example.demo.designpattern.builderpattern.demo1;

/**
 * @package: com.example.demo.designpattern.builderpattern.demo1
 * @author:
 * @email:
 * @createDate: 2019-06-10 18:04
 * @description:
 */
public abstract class Burger implements Item {
    @Override
    public abstract String name();

    @Override
    public Packing packing() {
        return new Wrapper();
    }

    @Override
    public abstract float price();
}
