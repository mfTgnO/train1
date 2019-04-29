package com.example.demo.java8lambdas.methodreferences;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

/**
 * @Package: com.example.demo.java8lambdas.methodreferences
 * @Author:
 * @Email:
 * @CreateDate: 2019-04-29 14:57
 * @Description:
 */
public class ExecuteAround {
    // method we want to refactor to make more flexible
    // processFileLimited
    @Test
    public void test1() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(new File("").getAbsolutePath() + "/src/main/resources/lambdasinaction/chap3/data.txt"));) {
            String read = br.readLine();
            System.out.println(read);
        }
    }

    @Test
    public void test5() throws IOException {
        String result = processFile(BufferedReader::readLine);
        System.out.println(result);
    }

    @Test
    public void test6() throws IOException {
        String result = processFile((BufferedReader b) -> b.readLine() + b.readLine());
        System.out.println(result);
    }

    // processFile
    public String processFile(BufferedReaderProcessor p) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(new File("").getAbsolutePath() + "/src/main/resources/lambdasinaction/chap3/data.txt"));) {
            return p.process(br);
        }
    }

    public interface BufferedReaderProcessor {
        String process(BufferedReader p) throws IOException;
    }


    @Test
    public void test2() {
        String absolutePath = new File("").getAbsolutePath();
        System.out.print(absolutePath);
    }

    @Test
    public void test3() {
        String absolutePath = new File(".").getAbsolutePath();
        System.out.print(absolutePath);
    }

    @Test
    public void test4() {
        URL resource = getClass().getResource("");
        System.out.println(resource);
    }
}
