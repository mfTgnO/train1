package com.example.demo.controller.async;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;

/**
 * @author Administrator
 */
@RestController
public class AsyncTestController {
    @GetMapping(value = "/sync")
    public String sync() {
        try {
            Thread.sleep(1000);
            System.out.println("sync");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "sync";
    }

    @GetMapping(value = "/async")
    public Callable<String> async() {
        // 使用异步将不会阻塞tomcat的io读写线程池、使得增加系统的吞吐量
        return () -> {
            Thread.sleep(1000);
            System.out.println("async");
            return "async";
        };
    }
}