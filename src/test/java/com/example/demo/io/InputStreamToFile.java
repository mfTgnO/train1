package com.example.demo.io;

import org.junit.Test;

import java.io.*;

/**
 * @package: com.example.demo.io
 * @author:
 * @email:
 * @createDate: 2019-06-13 20:17
 * @description:
 */
public class InputStreamToFile {
    /**
     * Files can be read using Reader or Stream in java. Reader is good to use for text data but to work with binary
     * data you should use Stream. FileInputStream is used to open the stream to read data from file. Here we will convert
     * InputStream to file in java, we will use OutputStream to write the new file.
     */
    @Test
    public void test1() {
        try {
            InputStream is = new FileInputStream("FileWriter.txt");
            OutputStream os = new FileOutputStream("NesFileWriter.txt");
            byte[] buffer = new byte[1024];
            int bytesRead;

            //read from is to buffer
            while ((bytesRead = is.read(buffer)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            is.close();

            //flush OutputStream to write any buffered data to file
            os.flush();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
