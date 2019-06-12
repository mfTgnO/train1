package com.example.demo.io;

import java.io.File;
import java.io.IOException;

/**
 * @package: com.example.demo.io
 * @author:
 * @email:
 * @createDate: 2019-06-12 10:40
 * @description: java.io.File class exists() method can be used to check if file exists or
 * not in java. If file exists, it returns true else this method returns false.
 */
public class FileExists {
    public static void main(String[] args) {
        File file = new File("D:\\java.txt");
        File notExist = new File("D:\\xyz.txt");
        try {
            System.out.println(file.getCanonicalPath() + " exists? " + file.exists());
            System.out.println(notExist.getCanonicalPath() + " exists? " + notExist.exists());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
