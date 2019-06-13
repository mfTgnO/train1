package com.example.demo.io;

import org.junit.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

/**
 * @package: com.example.demo.io
 * @author:
 * @email:
 * @createDate: 2019-06-13 19:45
 * @description:
 */
public class ReadFileLineByLineUsingBufferedReader {
    private String fileName = "D:\\java.txt";

    /**
     * Java Read File line by line using BufferedReader
     * <p>
     * We can use java.io.BufferedReader readLine() method to read file line by line to String.
     * This method returns null when end of file is reached. Below is a simple program showing example
     * for java read file line by line using BufferedReader.
     */
    @Test
    public void test1() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                // read next line
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Java Read File line by line using Scanner
     * <p>
     * We can use Scanner to open a file and then read it’s content line by line.
     * Below is the scanner example to read file line by line and print it.
     */
    @Test
    public void test2() {
        try {
            Scanner scanner = new Scanner(new File(fileName));
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Java Read File line by line using Files
     * <p>
     * java.nio.file.Files is a utility class that contains various useful methods.
     * Files readAllLines method can be used to read all the file lines into a list of string.
     */
    @Test
    public void test3() {
        try {
            List<String> allLines = Files.readAllLines(Paths.get(fileName));
            for (String line : allLines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Java Read File line by line using RandomAccessFile
     * <p>
     * We can use RandomAccessFile to open a file in read mode and then use its readLine method to read file line by line.
     */
    @Test
    public void test4() {
        try {
            RandomAccessFile file = new RandomAccessFile(fileName, "r");
            String str;
            while ((str = file.readLine()) != null) {
                System.out.println(str);
            }
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
