package com.example.demo.io;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * @package: com.example.demo.io
 * @author:
 * @email:
 * @createDate: 2019-06-12 11:11
 * @description: Today we will look into java file path. Java File path can be abstract, absolute or canonical.
 * <p>
 * Java File Path
 * java.io.File contains three methods for determining the file path, we will explore them in this tutorial.
 * <p>
 * 1.getPath(): This file path method returns the abstract pathname as String. If String pathname is used to
 * create File object, it simply returns the pathname argument. If URI is used as argument then it removes
 * the protocol and returns the file name.
 * <p>
 * 2.getAbsolutePath(): This file path method returns the absolute path of the file. If File is created with
 * absolute pathname, it simply returns the pathname.
 * <p>
 * If file object is created using relative path, the absolute pathname is resolved in a system-dependent way.
 * On UNIX systems, a relative pathname is made absolute by resolving it against the current user directory.
 * <p>
 * On Microsoft Windows systems, a relative pathname is made absolute by resolving it against the current
 * directory of the drive named by the pathname, if any; if not, it is resolved against the current user directory.
 * <p>
 * 3.getCanonicalPath(): This path method returns the canonical pathname that is both absolute and unique.
 * This method first converts this pathname to absolute form if necessary, as if by invoking the getAbsolutePath
 * method, and then maps it to its unique form in a system-dependent way.
 * <p>
 * This typically involves removing redundant names such as “.” and “..” from the pathname, resolving
 * symbolic links (on UNIX platforms), and converting drive letters to a standard case (on Microsoft Windows platforms).
 */
public class JavaFilePath {
    public static void main(String[] args) throws IOException, URISyntaxException {
        File file = new File("D:\\java.txt");
        printPaths(file);

        // relative path
        file = new File("demo.log");
        printPaths(file);

        // complex relative paths
        file = new File("D:\\dl\\fdm\\..\\putty\\PUTTY.HLP");
        printPaths(file);

        // URI paths
        file = new File(new URI("file:///D:/java.txt"));
        printPaths(file);
    }

    private static void printPaths(File file) throws IOException {
        System.out.println("Absolute Path: " + file.getAbsolutePath());
        System.out.println("Canonical Path: " + file.getCanonicalPath());
        System.out.println("Path: " + file.getPath());
        System.out.println();
    }
}
