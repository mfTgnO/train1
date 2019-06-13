package com.example.demo.io;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

/**
 * @package: com.example.demo.io
 * @author:
 * @email:
 * @createDate: 2019-06-12 19:49
 * @description:
 */
public class ReadFile {
    private String fileName = "D:\\java.txt";

    /**
     * Java read text file using java.nio.file.Files
     * <p>
     * We can use Files class to read all the contents of a file into byte array.
     * Files class also has a method to read all lines to a list of string. Files class is introduced
     * in Java 7 and it’s good if you want to load all the file contents. You should use this method
     * only when you are working on small files and you need all the file contents in memory.
     */
    @Test
    public void test1() throws IOException {
        Path path = Paths.get(fileName);
        byte[] bytes = Files.readAllBytes(path);
        List<String> allLines = Files.readAllLines(path, StandardCharsets.UTF_8);
        System.out.println(allLines);
    }

    /**
     * Java read text file using java.io.BufferedReader
     * <p>
     * You can use FileReader to get the BufferedReader and then read files line by line.
     * FileReader doesn’t support encoding and works with the system default encoding, so it’s
     * not very efficient way of reading text file in java.
     */
    @Test
    public void test2() throws IOException {
        File file = new File(fileName);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
    }

    /**
     * Using scanner to read text file in java
     * <p>
     * If you want to read file line by line or based on some java regular expression, Scanner is the class to use.
     * Scanner breaks its input into tokens using a delimiter pattern, which by default matches whitespace.
     * The resulting tokens may then be converted into values of different types using the various next methods.
     * Scanner is not synchronized and hence not thread safe.
     */
    @Test
    public void test3() throws IOException {
        Path path = Paths.get(fileName);
        Scanner scanner = new Scanner(path);
        System.out.println("Read text file using Scanner");

        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            System.out.println(line);
        }
        scanner.close();
    }

    /**
     * Java Read File Example
     * <p>
     * Here is the example class showing how to read text file in java.
     * The example methods are using Scanner, Files, BufferedReader with Encoding support and FileReader.
     */
    @Test
    public void test4() throws IOException {

    }
}

