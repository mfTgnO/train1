package com.example.demo.collections;

import org.junit.Test;

import java.nio.charset.Charset;
import java.util.Base64;

/**
 * @Package: com.example.demo.collections
 * @Author:
 * @Email:
 * @CreateDate: 2019-04-27 10:11
 * @Description:
 */
public class ByteArrayToString {
    @Test
    public void test1() {
        String name = "howtodoinjava.com";

        byte[] byteArray = name.getBytes();

        String str = new String(byteArray);
        String strWithCharset = new String(byteArray, Charset.defaultCharset());

        System.out.println("Original String: " + name);
        System.out.println("Obtained String: " + str);
        System.out.println("Obtained String: " + strWithCharset);
    }

    @Test
    public void test2() {
        Charset charset = Charset.defaultCharset();
        System.out.println(charset);
    }

    // Base64 class in Java 8
    // As you might be aware of – Base64 is a way to encode binary data, while UTF-8 and UTF-16 are ways to encode Unicode text data. So if you need to encode arbitrary binary data as text, Base64 is the way to go.
    // byte array to string
    @Test
    public void test3() {
        String name = "howtodoinjava.com";
        byte[] byteArray = name.getBytes();

        String str = Base64.getEncoder().encodeToString(byteArray);
        System.out.println(str);

        byte[] decode = Base64.getDecoder().decode(str);
        System.out.println(new String(decode));
    }
}
