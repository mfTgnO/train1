package com.example.demo.designpattern.singletonpattern.demo1;

import org.junit.Test;

/**
 * @package: com.example.demo.designpattern.singletonpattern
 * @author:
 * @email:
 * @createDate: 2019-06-10 17:57
 * @description:
 */
public class SingletonPatternDemo {
    @Test
    public void test(){
        SingleObject singleObject = SingleObject.getSingleObject();
        singleObject.showMessage();
    }
}
