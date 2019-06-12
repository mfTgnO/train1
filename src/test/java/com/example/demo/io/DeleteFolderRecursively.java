package com.example.demo.io;

import org.junit.Test;

import java.io.File;

/**
 * @package: com.example.demo.io
 * @author:
 * @email:
 * @createDate: 2019-06-12 09:38
 * @description:
 */
public class DeleteFolderRecursively {
    @Test
    public void test() {
//        String folder = "/Users/pankaj/tmp";
        String folder = "D:\\idea\\svn\\xjerp";

        //delete folder recursively
//        recursiveDelete(new File(folder));
        recursiveDeleteV2(new File(folder));
    }

    public static void recursiveDelete(File file) {
        //to end the recursive loop
        if (!file.exists()) {
            return;
        }
        //if directory, go inside and call recursively
        if (file.isDirectory()) {
            for (File f : file.listFiles()) {
                //call recursively
                recursiveDelete(f);
            }
        }

        //call delete to delete files and empty directory
        file.delete();
        System.out.println("Deleted file/folder: " + file.getAbsolutePath());
    }

    /*
    * 递归删除空文件夹
    * */
    public static void recursiveDeleteV2(File file) {
        //to end the recursive loop
        if (!file.exists()) {
            return;
        }
        //if directory, go inside and call recursively
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (file.length() > 0) {
                for (File f : files) {
                    //call recursively
                    recursiveDelete(f);
                }
            } else {
                file.delete();
                System.out.println("Deleted file/folder: " + file.getAbsolutePath());
            }
        }
    }
}
