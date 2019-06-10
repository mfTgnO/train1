package com.example.demo.designpattern.abstractfactorypattern.demo1;

/**
 * @package: com.example.demo.designpattern.abstractfactorypattern.demo1
 * @author:
 * @email:
 * @createDate: 2019-06-10 17:46
 * @description:
 */
public class FactoryProducer {
    public static AbstractFactory getFactory(boolean rounded) {
        if (rounded) {
            return new RoundedShapeFactory();
        } else {
            return new ShapeFactory();
        }
    }
}
