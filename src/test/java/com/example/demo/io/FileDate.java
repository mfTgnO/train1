package com.example.demo.io;

import java.io.File;
import java.util.Date;

/**
 * @package: com.example.demo.io
 * @author:
 * @email:
 * @createDate: 2019-06-12 10:45
 * @description: Sometimes we need to get the file last modified date in java, usually for listeners like JBoss
 * rabbitmq file changes hot deployment. java.io.File class lastModified() returns last modified date in long,
 * we can construct date object in human readable format with this time.
 */
public class FileDate {
    public static void main(String[] args) {
        File file = new File("D:\\java.txt");
        long timestamp = file.lastModified();
        System.out.println("employee.xml last modified date = " + new Date(timestamp));
    }
}
