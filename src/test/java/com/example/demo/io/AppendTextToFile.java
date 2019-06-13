package com.example.demo.io;

import org.junit.Test;

import java.io.*;

/**
 * If you are working on text data and number of write operations are less, use FileWriter
 * and use it’s constructor with append flag value as true. If the number of write operations
 * are huge, you should use the BufferedWriter.
 * <p>
 * To append binary or raw stream data to an existing file, you should use FileOutputStream.
 */
public class AppendTextToFile {
    private String fileName = "FileWriter.txt";

    /**
     * Java append to file using FileWriter
     * <p>
     * Here is the short program to append to file in java using FileWriter.
     * We will look into a complete java append to file example program later on.
     */
    @Test
    public void test1() {
        File file = new File(fileName);
        FileWriter fw = null;
        try {
            fw = new FileWriter(file, true);
            fw.write("data");
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
     * Java append content to existing file using BufferedWriter
     */
    @Test
    public void test2() {
        File file = new File(fileName);
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(file, true);
            bw = new BufferedWriter(fw);
            bw.write("data");
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
     * Append text to file in java using PrintWriter
     */
    @Test
    public void test3() {
        File file = new File(fileName);
        FileWriter fw = null;
        BufferedWriter bw = null;
        PrintWriter pw = null;
        try {
            fw = new FileWriter(file, true);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);
            pw.println("data");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                pw.close();
                bw.close();
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Append to file in java using FileOutputStream
     */
    @Test
    public void test4() {
        OutputStream fos = null;
        try {
            fos = new FileOutputStream(new File(fileName), true);
            fos.write("data".getBytes(), 0, "data".length());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
