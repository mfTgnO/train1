package com.example.demo.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermission;
import java.util.HashSet;
import java.util.Set;

/**
 * @package: com.example.demo.io
 * @author:
 * @email:
 * @createDate: 2019-06-12 11:21
 * @description: Java File class has the ability to set the file permissions but it’s not versatile.
 * <p>
 * The biggest drawback is that you can divide file permissions into two set of users – owner and
 * everybody else only. You can’t set different file permissions for group and other users.
 * <p>
 * Java 7 has introduced PosixFilePermission Enum and java.nio.file.Files includes a method
 * setPosixFilePermissions(Path path, Set<PosixFilePermission> perms) that can be used to set file permissions easily.
 */
public class FilePermissions {
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\dl\\TeamViewer_Setup.exe");

        //set application user permissions to 455
        file.setExecutable(false);
        file.setReadable(false);
        file.setWritable(true);

        //change permission to 777 for all the users
        //no option for group and others
        file.setExecutable(true, false);
        file.setReadable(true, false);
        file.setWritable(true, false);

        //using PosixFilePermission to set file permissions 777
        Set<PosixFilePermission> perms = new HashSet<>();

        //add owners permission
        perms.add(PosixFilePermission.OWNER_READ);
        perms.add(PosixFilePermission.OWNER_WRITE);
        perms.add(PosixFilePermission.OWNER_EXECUTE);

        //add group permissions
        perms.add(PosixFilePermission.GROUP_READ);
        perms.add(PosixFilePermission.GROUP_WRITE);
        perms.add(PosixFilePermission.GROUP_EXECUTE);

        //add others permissions
        perms.add(PosixFilePermission.OTHERS_READ);
        perms.add(PosixFilePermission.OTHERS_WRITE);
        perms.add(PosixFilePermission.OTHERS_EXECUTE);
        Files.setPosixFilePermissions(Paths.get("D:\\dl\\TeamViewer_Setup.exe"), perms);
    }
}
