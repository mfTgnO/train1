package com.example.demo.io;

import org.junit.Test;

import java.io.File;

/**
 * @package: com.example.demo.io
 * @author:
 * @email:
 * @createDate: 2019-06-12 10:30
 * @description: Sometimes while working with files, we need to process differently based on it’s
 * type. java.io.File doesn’t have any method to get the file extension, here I am providing a utility
 * method to get the file extension in java.
 */
public class GetFileExtension {
    @Test
    public void test() {
        File file = new File("D:\\java.txt");
        System.out.println("File extension is: " + getFileExtension(file));

        //file name without extension
        file = new File("D:\\temp");
        System.out.println("File extension is: " + getFileExtension(file));

        //file name with dot
        file = new File("D:\\java.util.txt");
        System.out.println("File extension is: " + getFileExtension(file));

        //hidden files without extension
        file = new File("D:\\.htaccess");
        System.out.println("File extension is: " + getFileExtension(file));
    }

    private static String getFileExtension(File file) {
        String fileName = file.getName();
        if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
            return fileName.substring(fileName.lastIndexOf(".") + 1);
        else return "";
    }
}