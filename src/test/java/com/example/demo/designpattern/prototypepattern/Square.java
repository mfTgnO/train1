package com.example.demo.designpattern.prototypepattern;

/**
 * @package: com.example.demo.designpattern.prototypepattern
 * @author:
 * @email:
 * @createDate: 2019-06-10 18:45
 * @description:
 */
public class Square extends Shape {
    @Override
    void draw() {
        System.out.println("Inside Square::draw() method.");
    }

    public Square() {
        type = "Square";
    }
}
