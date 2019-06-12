package com.example.demo.io;

import java.io.File;

/**
 * @package: com.example.demo.io
 * @author:
 * @email:
 * @createDate: 2019-06-12 10:42
 * @description: java.io.File class contains two methods using which we can find out if the file is a directory or a regular file in java.
 * <p>
 * 1.isFile(): This method returns true if file exists and is a regular file, note that if file doesn’t exist then it returns false.
 * 2.isDirectory(): This method returns true if file is actually a directory, if path doesn’t exist then it returns false.
 * <p>
 * While checking if a file is directory or regular file, we should first check if file exists or not.
 * If it exists then only we should check if it’s a directory or file.
 */
public class CheckDirectoryOrFile {

    public static void main(String[] args) {
        File file = new File("D:\\java.txt");
        File dir = new File("D:\\dl\\fdm");
        File notExists = new File("D:\\xyz.txt");

        System.out.println("D:\\java.txt is file?" + file.isFile());
        System.out.println("D:\\java.txt is directory?" + file.isDirectory());
        System.out.println("D:\\dl\\fdm is file?" + dir.isFile());
        System.out.println("D:\\dl\\fdm is directory?" + dir.isDirectory());
        System.out.println("D:\\xyz.txt is file?" + notExists.isFile());
        System.out.println("D:\\xyz.txt is directory?" + notExists.isDirectory());
    }
}
