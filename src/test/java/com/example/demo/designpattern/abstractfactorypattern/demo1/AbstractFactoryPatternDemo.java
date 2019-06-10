package com.example.demo.designpattern.abstractfactorypattern.demo1;

import org.junit.Test;

/**
 * @package: com.example.demo.designpattern.abstractfactorypattern.demo1
 * @author:
 * @email:
 * @createDate: 2019-06-10 17:47
 * @description:
 */
public class AbstractFactoryPatternDemo {
    @Test
    public void test1() {
        AbstractFactory factory = FactoryProducer.getFactory(false);

        Shape rectangle = factory.getShape("RECTANGLE");
        rectangle.draw();

        Shape square = factory.getShape("SQUARE");
        square.draw();
    }

    @Test
    public void test2() {
        AbstractFactory factory = FactoryProducer.getFactory(true);

        Shape rectangle = factory.getShape("RECTANGLE");
        rectangle.draw();

        Shape square = factory.getShape("SQUARE");
        square.draw();
    }
}
