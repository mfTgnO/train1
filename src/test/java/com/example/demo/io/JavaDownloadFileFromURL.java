package com.example.demo.io;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

/**
 * @package: com.example.demo.io
 * @author:
 * @email:
 * @createDate: 2019-06-13 20:25
 * @description: Today we will learn how to download a file from URL in java. We can use java.net.URL openStream()
 * method to download file from URL in java program. We can use Java NIO Channels or Java IO InputStream to read data
 * from the URL open stream and then save it to file.
 */
public class JavaDownloadFileFromURL {
    /**
     * downloadUsingStream:
     * <p>
     * In this method of java download file from URL, we are using URL openStream method to
     * create the input stream. Then we are using a file output stream to read data from the
     * input stream and write to the file.
     * <p>
     * downloadUsingNIO:
     * In this download file from URL method, we are creating byte channel from URL stream data.
     * Then use the file output stream to write it to file.
     * <p>
     * You can use any of these methods to download the file from URL in java program.
     * If you are looking for performance, then do some analysis by using both methods and see what suits your need.
     */
    public static void main(String[] args) {
        String url = "https://www.journaldev.com/sitemap.xml";

        try {
            downloadUsingNIO(url, "sitemap.xml");

            downloadUsingStream(url, "sitemap_stream.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void downloadUsingStream(String urlStr, String file) throws IOException {
        URL url = new URL(urlStr);
        BufferedInputStream bis = new BufferedInputStream(url.openStream());
        FileOutputStream fis = new FileOutputStream(file);
        byte[] buffer = new byte[1024];
        int count = 0;
        while ((count = bis.read(buffer, 0, 1024)) != -1) {
            fis.write(buffer, 0, count);
        }
        fis.close();
        bis.close();
    }

    private static void downloadUsingNIO(String urlStr, String file) throws IOException {
        URL url = new URL(urlStr);
        ReadableByteChannel rbc = Channels.newChannel(url.openStream());
        FileOutputStream fos = new FileOutputStream(file);
        fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        fos.close();
        rbc.close();
    }
}