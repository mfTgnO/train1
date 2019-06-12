package com.example.demo.io;

import java.io.File;
import java.io.FilenameFilter;

/**
 * @package: com.example.demo.io
 * @author:
 * @email:
 * @createDate: 2019-06-12 10:47
 * @description:
 */
public class FileNameFilterExample {
    public static void main(String[] args) {
        String dir = "D:\\";
        String ext = ".txt";
        findFiles(dir, ext);
    }

    private static void findFiles(String dir, String ext) {
        File file = new File(dir);
        if (!file.exists())
            System.out.println(dir + " Directory doesn't exists");

//        File[] listFiles = file.listFiles(new MyFileNameFilter(ext));
        // FileNameFilter in java with lambda expression
        File[] listFiles = file.listFiles((d, s) -> s.toLowerCase().endsWith(ext));

        if (listFiles.length == 0) {
            System.out.println(dir + "doesn't have any file with extension " + ext);
        } else {
            for (File f : listFiles)
                System.out.println("File: " + dir + File.separator + f.getName());
        }
    }

    // FileNameFilter implementation
    public static class MyFileNameFilter implements FilenameFilter {

        private String ext;

        public MyFileNameFilter(String ext) {
            this.ext = ext.toLowerCase();
        }

        @Override
        public boolean accept(File dir, String name) {
            return name.toLowerCase().endsWith(ext);
        }
    }
}
