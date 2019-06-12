package com.example.demo.io;

import org.junit.Test;

import java.io.File;

/**
 * @package: com.example.demo.io
 * @author:
 * @email:
 * @createDate: 2019-06-12 10:01
 * @description: Java Rename file or move file is a common IO operation. We can use File.renameTo(File dest)
 * method for java rename file and java move file operations.
 * <p>
 * Java Rename File
 * File renameTo method returns true if file rename is successful, else it returns false.
 * Some of the rename operation behaviours are platform dependent. For example it might fail if
 * you move a file from one filesystem to another or if a file already exists with the same name at destination directory.
 * In Mac OS, if destination file already exists renameTo override the existing file with source file.
 * <p>
 * Java Move File
 * Moving is file is achieved by renameTo function itself. Moving a file doesn’t change file content,
 * just it’s directory location. A file complete path contains directory information with file name,
 * renameTo method is able to change the directory path too, hence move the file.
 */
public class RenameFile {
    /*
     * absolute path rename file
     * */
    @Test
    public void test1() {
        File file = new File("D:\\java.txt");
        File newFile = new File("D:\\java1.txt");
        if (file.renameTo(newFile)) {
            System.out.println("File rename success");
        } else {
            System.out.println("File rename failed");
        }
    }

    /*
     * relative path rename file
     * */
    @Test
    public void test2() {
        File file = new File("DB.properties");
        File newFile = new File("DB_New.properties");
        if (file.renameTo(newFile)) {
            System.out.println("File rename success");
            ;
        } else {
            System.out.println("File rename failed");
        }
    }

    /*
     * java move file from one directory to another
     * */
    @Test
    public void test3() {
        File file = new File("D:\\java1.txt");
        File newFile = new File("DB_Move.properties");
        if (file.renameTo(newFile)) {
            System.out.println("File move success");
            ;
        } else {
            System.out.println("File move failed");
        }
    }

    /*
     * when source file is not present
     * */
    @Test
    public void test4() {
        File file = new File("/Users/pankaj/xyz.txt");
        File newFile = new File("xyz.properties");
        if (file.renameTo(newFile)) {
            System.out.println("File move success");
        } else {
            System.out.println("File move failed");
        }
    }

    /*
     * when destination already have a file with same name
     * */
    @Test
    public void test5() {
        File file = new File("D:\\java.txt");
        File newFile = new File("DB_Move.properties");
        if (file.renameTo(newFile)) {
            System.out.println("File move success");
        } else {
            System.out.println("File move failed");
        }
    }
}
