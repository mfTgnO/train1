package com.example.demo.io;

import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @package: com.example.demo.io
 * @author:
 * @email:
 * @createDate: 2019-06-11 20:03
 * @description:
 */
public class CreateNewFile {
    /*
     * absolute file name with path
     * */
    @Test
    public void test1() throws IOException {
        String fileSeparator = System.getProperty("file.separator");
        System.out.println(fileSeparator);

        String absoluteFilePath = fileSeparator + "Users" + fileSeparator + "pankej" + "file.txt";
        File file = new File(absoluteFilePath);
        if (file.createNewFile()) {
            System.out.println(absoluteFilePath + " File Created");
        } else {
            System.out.println("File " + absoluteFilePath + " already exists");
        }
    }

    /*
     * file name only
     * */
    @Test
    public void test2() throws IOException {
        File file = new File("file.txt");
        if (file.createNewFile()) {
            System.out.println("file.txt File Created in Project root directory");
        } else {
            System.out.println("File file.txt already exists in the project root directory");
        }
    }


    /*
     * relative path
     * */
    @Test
    public void test3() throws IOException {
        String fileSeparator = System.getProperty("file.separator");
        String relativePath = "tmp" + fileSeparator + "file.txt";

        File file = new File(relativePath);
        if (file.createNewFile()) {
            System.out.println(relativePath + " File Created in Project root directory");
        } else System.out.println("File " + relativePath + " already exists in the project root directory");
    }

    /*
     * How to get the current working directory in Java
     * https://www.mkyong.com/java/how-to-get-the-current-working-directory-in-java/
     * */
    @Test
    public void test4() {
        String currentWorkingDirectory = System.getProperty("user.dir");
        System.out.println(currentWorkingDirectory);
    }

    /*
     * FileOutputStream.write(byte[] b)
     *
     * If you want to create a new file and at the same time write some data into it,
     * you can use FileOutputStream write method. Below is a simple code snippet to
     * show it’s usage. The rules for absolute path and relative path discussed above
     * is applicable in this case too.
     * */
    @Test
    public void test5() throws IOException {
        String fileData = "Pankaj Kumar";
        FileOutputStream fos = new FileOutputStream("name.txt");
        fos.write(fileData.getBytes());
        fos.flush();
        fos.close();
    }

    /*
     * Java NIO Files.write()
     *
     * We can use Java NIO Files class to create a new file and write some data into it.
     * This is a good option because we don’t have to worry about closing IO resources.
     * */
    @Test
    public void test6() throws IOException {
        String fileData = "Pankaj Kumar";
        Files.write(Paths.get("name.txt"), fileData.getBytes(), StandardOpenOption.CREATE);
    }
}
