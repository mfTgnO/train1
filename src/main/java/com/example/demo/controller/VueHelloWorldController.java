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
     * http://127.0.0.1:8080/vueHelloWorld
     *
     * @return String
     */
    @GetMapping("/vueHelloWorld")
    public String vueHelloWorld() {
        log.info("vueHelloWorld");
        return "vueHelloWorld";
    }

    /**
     * http://127.0.0.1:8080/layuiDemo
     *
     * @return String
     */
    @GetMapping("/layuiDemo")
    public String layuiDemo() {
        log.info("layuiDemo");
        return "layuiDemo";
    }

    /**
     * http://127.0.0.1:8080/paging
     *
     * @return String
     */
    @GetMapping("/paging")
    public String paging() {
        log.info("paging");
        return "paging";
    }
}
