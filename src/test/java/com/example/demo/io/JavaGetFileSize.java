package com.example.demo.io;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @package: com.example.demo.io
 * @author:
 * @email:
 * @createDate: 2019-06-12 10:22
 * @description: Java File length() method returns the file size in bytes.
 * The return value is unspecified if this file denotes a directory.
 * So before calling this method to get file size in java, make sure file exists and it’s not a directory.
 */
public class JavaGetFileSize {
    private static final String FILE_NAME = "D:\\dl\\apache-jmeter-5.1.1(1).zip";

    /*
     * Java get file size using File class
     * */
    @Test
    public void test1() {
        File file = new File(FILE_NAME);
        if (!file.exists() || !file.isFile()) {
            return;
        }

        System.out.println(getFileSizeBytes(file));
        System.out.println(getFileSizeKiloBytes(file));
        System.out.println(getFileSizeMegaBytes(file));
    }

    /*
     * Get file size in java using FileChannel class
     * */
    @Test
    public void test2() {
        Path filePath = Paths.get(FILE_NAME);
        FileChannel fileChannel;
        try {
            fileChannel = FileChannel.open(filePath);
            long fileSize = fileChannel.size();
            System.out.println(fileSize + " bytes");
            fileChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
     * Java get file size using Apache Commons IO FileUtils class
     *
     * If you are already using Apache Commons IO in your project, then you can use FileUtils sizeOf method to get file size in java.
     * */
    @Test
    public void test3() {
        File file = new File(FILE_NAME);
        long fileSize = FileUtils.sizeOf(file);
        System.out.println(fileSize + " bytes");
    }

    private static String getFileSizeMegaBytes(File file) {
        return (double) file.length() / (1024 * 1024) + " mb";
    }

    private static String getFileSizeKiloBytes(File file) {
        return (double) file.length() / 1024 + " kb";
    }

    private static String getFileSizeBytes(File file) {
        return file.length() + " bytes";
    }
}
