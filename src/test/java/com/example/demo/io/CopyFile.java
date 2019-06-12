package com.example.demo.io;

import org.junit.Before;
import org.junit.Test;

import java.io.*;

/**
 * @package: com.example.demo.io
 * @author:
 * @email:
 * @createDate: 2019-06-12 11:28
 * @description: Java copy file is a very common operation. But java.io.File class doesn’t have any shortcut method to
 * copy file from source to destination. Here we will learn about four different ways we can copy file in java.
 */
public class CopyFile {
    private File source;
    private File dest;

    @Before
    public void beforeResource() {
        source = new File("D:\\iotest\\source.exe");
        dest = new File("D:\\iotest\\dest.exe");
    }

    /*
     * Java Copy File – Stream
     *
     * This is the conventional way of file copy in java, here we create two Files, source and destination.
     * Then we create InputStream from source and write it to destination file using OutputStream for java copy file operation.
     *
     * Here is the method that can be used for java copy file using streams.
     * */
    @Test
    public void test1() throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } finally {
            assert is != null;
            is.close();
            assert os != null;
            os.close();
        }
    }
}
