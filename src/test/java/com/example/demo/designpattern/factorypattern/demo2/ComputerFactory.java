package com.example.demo.designpattern.factorypattern.demo2;

/**
 * @package: com.example.demo.designpattern.factorypattern.demo2
 * @author:
 * @email:
 * @createDate: 2019-06-10 19:11
 * @description:
 */
public class ComputerFactory {
    public static Computer getComputer(String type, String ram, String hdd, String cpu) {
        if ("PC".equalsIgnoreCase(type)) return new PC(ram, hdd, cpu);
        else if ("Server".equalsIgnoreCase(type)) return new Server(ram, hdd, cpu);

        return null;
    }
}
