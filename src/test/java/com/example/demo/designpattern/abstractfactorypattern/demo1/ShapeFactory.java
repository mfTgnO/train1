package com.example.demo.designpattern.abstractfactorypattern.demo1;

/**
 * @package: com.example.demo.designpattern.abstractfactorypattern.demo1
 * @author:
 * @email:
 * @createDate: 2019-06-10 17:41
 * @description:
 */
public class ShapeFactory extends AbstractFactory {
    @Override
    Shape getShape(String shapeType) {
        if (shapeType.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle();
        } else if (shapeType.equalsIgnoreCase("SQUARE")) {
            return new Square();
        }
        return null;
    }
}
