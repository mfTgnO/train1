package com.example.demo.io;

import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * @package: com.example.demo.io
 * @author:
 * @email:
 * @createDate: 2019-06-12 19:44
 * @description:
 */
public class JavaOpenFile {
    public static void main(String[] args) throws IOException {
        //text file, should be opening in default text editor
        File file = new File("D:\\java.txt");

        //first check if Desktop is supported by Platform or not
        if (!Desktop.isDesktopSupported()) {
            System.out.println("Desktop is not supported");
            return;
        }
        Desktop desktop = Desktop.getDesktop();
        if (file.exists()) desktop.open(file);
/*
        //let's try to open PDF file
        file = new File("/Users/pankaj/java.pdf");
        if (file.exists()) desktop.open(file);*/
    }
}
