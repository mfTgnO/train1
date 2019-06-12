package com.example.demo.io;

import org.junit.Test;

import java.io.File;

/**
 * @package: com.example.demo.io
 * @author:
 * @email:
 * @createDate: 2019-06-12 09:35
 * @description: java.io.File class contains four static separator variables. Here we will learn about them and when to use it.
 * 1.File.separator: Platform dependent default name-separator character as String. For windows, it’s ‘\’ and for unix it’s ‘/’.
 * 2.File.separatorChar: Same as separator but it’s char.
 * 3File.pathSeparator: Platform dependent variable for path-separator. For example PATH or CLASSPATH variable list of paths separated by ‘:’ in Unix systems and ‘;’ in Windows system.
 * 4.File.pathSeparatorChar: Same as pathSeparator but it’s char.
 */
public class FileSeparator {
    @Test
    public void test1() {
        System.out.println("File.separator = " + File.separator);
        System.out.println("File.separatorChar = " + File.separatorChar);
        System.out.println("File.pathSeparator = " + File.pathSeparator);
        System.out.println("File.pathSeparatorChar = " + File.pathSeparatorChar);
    }

    /*
     * no platform independence, good for Unix systems
     * */
    @Test
    public void test2() {
        File fileUnsafe = new File("tmp/abc.txt");
    }

    /*
     * platform independent and safe to use across Unix and Windows
     * */
    @Test
    public void test3() {
        File fileSafe = new File("tmp" + File.separator + "abc.txt");
    }
}
