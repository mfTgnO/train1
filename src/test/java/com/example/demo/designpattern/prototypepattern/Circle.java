package com.example.demo.designpattern.prototypepattern;

/**
 * @package: com.example.demo.designpattern.prototypepattern
 * @author:
 * @email:
 * @createDate: 2019-06-10 18:48
 * @description:
 */
public class Circle extends Shape {
    public Circle() {
        type = "Circle";
    }

    @Override
    void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
