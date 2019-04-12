package com.example.demo.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;

/**
 * @author Administrator
 */
@RestController
@Slf4j
public class AsyncTestController {
    @GetMapping(value = "/sync")
    public String sync() {
        log.info("sync Starts");
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("sync completed");
        return "sync";
    }

    @GetMapping(value = "/async")
    public Callable<String> async() {
        log.info("async Starts");
        // 使用异步将不会阻塞tomcat的io读写线程池、使得增加系统的吞吐量
        return () -> {
            Thread.sleep(1000);
            log.info("async completed");
            return "async";
        };
    }
}