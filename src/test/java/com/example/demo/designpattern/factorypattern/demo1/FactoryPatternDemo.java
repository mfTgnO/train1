package com.example.demo.designpattern.factorypattern.demo1;

/**
 * @package: com.example.demo.designpattern.factorypattern
 * @author:
 * @email:
 * @createDate: 2019-06-10 17:30
 * @description:
 */
public class FactoryPatternDemo {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        Shape circle = shapeFactory.getShape("CIRCLE");
        circle.draw();

        Shape rectangle = shapeFactory.getShape("RECTANGLE");
        rectangle.draw();

        Shape square = shapeFactory.getShape("SQUARE");
        square.draw();
    }
}
