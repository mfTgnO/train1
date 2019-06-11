package com.example.demo.io;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * @package: com.example.demo.io
 * @author:
 * @email:
 * @createDate: 2019-06-11 20:35
 * @description:
 */
public class DeleteFileJava {
    private String currentWorkingDirectory = System.getProperty("user.dir");

    /*
     * absolute file name with path
     * */
    @Test
    public void test1() {
        String path = currentWorkingDirectory + "/name.txt";

        File file = new File(path);
        if (file.delete()) {
            System.out.println(path + " File deleted");
        } else System.out.println(path + " doesn't exists");
    }

    /*
     * file name only
     * */
    @Test
    public void test2() {
        File file = new File("file.txt");
        if (file.delete()) {
            System.out.println("file.txt File deleted from Project root directory");
        } else System.out.println("File file.txt doesn't exists in project root directory");
    }

    /*
     * relative path
     * */
    @Test
    public void test3() {
        File file = new File("file.txt");
        if (file.delete()) {
            System.out.println("file.txt File deleted from Project root directory");
        } else System.out.println("File file.txt doesn't exists in project root directory");
    }

    /*
     * delete empty directory
     * */
    @Test
    public void test4() {
        File file = new File("tmp");
        if (file.delete()) {
            System.out.println("tmp directory deleted from Project root directory");
        } else System.out.println("tmp directory doesn't exists or not empty in project root directory");
    }

    /*
     * try to delete directory with files
     * */
    @Test
    public void test5() {
        File file = new File("/Users/pankaj/project");
        if (file.delete()) {
            System.out.println("/Users/pankaj/project directory deleted from Project root directory");
        } else System.out.println("/Users/pankaj/project directory doesn't exists or not empty");
    }

    /*
     * Java delete directory
     * Below is a simple program showing how to delete a non empty directory. This will work if your directory contains files only.
     * */
    @Test
    public void test6() {
        File dir = new File(currentWorkingDirectory + "/tmp");

        if (dir.isDirectory() == false) {
            System.out.println("Not a directory. Do nothing");
        } else {
            File[] listFiles = dir.listFiles();
            for (File file : listFiles) {
                System.out.println("Deleting " + file.getName());
                file.delete();
            }
            // now directory is empty, so we can delete it
            System.out.println("Deleting Directory. Success = " + dir.delete());
        }
    }

    /*
     * Java delete directory recursively
     *
     * Earlier we had to write recursion based code to delete a directory with
     * nested directories. But with Java 7, we can do this using Files class.
     * Below is the code that you should use to delete a directory. It takes care of deleting nested directories too.
     * */
    @Test
    public void test8() throws IOException {
        Path dir = Paths.get(currentWorkingDirectory + "/tmp");
        Files.walkFileTree(dir, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                Files.delete(file);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                Files.delete(dir);
                return FileVisitResult.CONTINUE;
            }
        });
    }
}
