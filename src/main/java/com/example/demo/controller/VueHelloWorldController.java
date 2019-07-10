package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @package: com.example.demo.controller
 * @author:
 * @email:
 * @createDate: 2019-07-10 11:43
 * @description:
 */
@Controller
@Slf4j
public class VueHelloWorldController {
    /**
     * http://192.168.11.108:8080/vueHelloWorld
     * @return
     */
    @GetMapping("/vueHelloWorld")
    public String vueHelloWorld() {
        log.info("vueHelloWorld");
        return "vueHelloWorld";
    }

    /**
     * http://192.168.11.108:8080/layuiDemo
     * @return
     */
    @GetMapping("/layuiDemo")
    public String layuiDemo() {
        log.info("layuiDemo");
        return "layuiDemo";
    }
}
