package com.example.demo.designpattern.factorypattern.demo2;

/**
 * @package: com.example.demo.designpattern.factorypattern.demo2
 * @author:
 * @email:
 * @createDate: 2019-06-10 19:08
 * @description:
 */
public abstract class Computer {
    public abstract String getRAM();

    public abstract String getHDD();

    public abstract String getCPU();

    @Override
    public String toString() {
        return "RAM= " + this.getRAM() + ", HDD=" + this.getHDD() + ", CPU=" + this.getCPU();
    }
}
