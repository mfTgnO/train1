package com.example.demo.io;

import org.junit.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @package: com.example.demo.io
 * @author:
 * @email:
 * @createDate: 2019-06-13 19:51
 * @description:
 */
public class WriteFile {
    private String fileName = "FileWriter.txt";
    private String data = "I will write this String to File in Java";
    private int noOfLines = 10000;

    /**
     * FileWriter:
     * <p>
     * FileWriter is the simplest way to write a file in java,
     * it provides overloaded write method to write int, byte array and String to the File.
     * You can also write part of the String or byte array using FileWriter. FileWriter writes directly
     * into Files and should be used only when number of writes are less.
     */
    @Test
    public void test1() {
        File file = new File(fileName);
        FileWriter fw = null;
        try {
            fw = new FileWriter(file);
            fw.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * BufferedWriter:
     * <p>
     * BufferedWriter is almost similar to FileWriter but it uses internal buffer to
     * write data into File. So if the number of write operations are more, the actual IO operations
     * are less and performance is better. You should use BufferedWriter when number of write operations are more.
     */
    @Test
    public void test2() {
        File file = new File(fileName);
        FileWriter fw = null;
        BufferedWriter bw = null;

        try {
            fw = new FileWriter(file);
            bw = new BufferedWriter(fw);
            for (int i = noOfLines; i > 0; i--) {
                bw.write(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bw.close();
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Files:
     *
     * Java 7 introduced Files utility class and we can write a file using it’s write function,
     * internally it’s using OutputStream to write byte array into file.
     */
    @Test
    public void test3() {
        try {
            Files.write(Paths.get(fileName), data.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * FileOutputStream:
     *
     * FileWriter and BufferedWriter are meant to write text to the file but when you need raw
     * stream data to be written into file, you should use FileOutputStream to write file in java.
     */
    @Test
    public void test4() {
        OutputStream os = null;
        try {
            os = new FileOutputStream(new File(fileName));
            os.write(data.getBytes(), 0, data.length());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
