package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author mango
 */
@Controller
@Slf4j
public class HomeController {
    @GetMapping("/")
    public String home() {
        log.info("/home");
        return "index";
    }
}