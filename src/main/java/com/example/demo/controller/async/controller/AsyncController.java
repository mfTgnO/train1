package com.example.demo.controller.async.controller;

import com.example.demo.controller.async.service.AsyncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class AsyncController {
    @Autowired
    private AsyncService asyncService;


}
