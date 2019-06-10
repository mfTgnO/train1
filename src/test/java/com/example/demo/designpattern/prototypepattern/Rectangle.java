package com.example.demo.designpattern.prototypepattern;

/**
 * @package: com.example.demo.designpattern.prototypepattern
 * @author:
 * @email:
 * @createDate: 2019-06-10 18:44
 * @description:
 */
public class Rectangle extends Shape {
    @Override
    void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }

    public Rectangle() {
        type = "Rectangle";
    }
}
