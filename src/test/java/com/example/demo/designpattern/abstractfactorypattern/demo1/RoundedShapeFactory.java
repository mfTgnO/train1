package com.example.demo.designpattern.abstractfactorypattern.demo1;

/**
 * @package: com.example.demo.designpattern.abstractfactorypattern.demo1
 * @author:
 * @email:
 * @createDate: 2019-06-10 17:44
 * @description:
 */
public class RoundedShapeFactory extends AbstractFactory {
    @Override
    Shape getShape(String shapeType) {
        if (shapeType.equalsIgnoreCase("RECTANGLE")) {
            return new RoundedRectangle();
        } else if (shapeType.equalsIgnoreCase("SQUARE")) {
            return new RoundedSquare();
        }
        return null;
    }
}
