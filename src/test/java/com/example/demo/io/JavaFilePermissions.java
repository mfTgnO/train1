package com.example.demo.io;

import java.io.File;

/**
 * @package: com.example.demo.io
 * @author:
 * @email:
 * @createDate: 2019-06-12 11:18
 * @description:
 */
public class JavaFilePermissions {
    public static void main(String[] args) {
        File file = new File("D:\\dl\\TeamViewer_Setup.exe");

        //check file permissions for application user
        System.out.println("File is readable? " + file.canRead());
        System.out.println("File is writable? " + file.canWrite());
        System.out.println("File is executable? " + file.canExecute());
        System.out.println();

        //change file permissions for application user only
        file.setReadable(false);
        file.setWritable(false);
        file.setExecutable(false);
        System.out.println("File is readable? " + file.canRead());
        System.out.println("File is writable? " + file.canWrite());
        System.out.println("File is executable? " + file.canExecute());
        System.out.println();

        //change file permissions for other users also
        file.setReadable(true, false);
        file.setWritable(true, false);
        file.setExecutable(true, true);
        System.out.println("File is readable? " + file.canRead());
        System.out.println("File is writable? " + file.canWrite());
        System.out.println("File is executable? " + file.canExecute());
        System.out.println();
    }
}
