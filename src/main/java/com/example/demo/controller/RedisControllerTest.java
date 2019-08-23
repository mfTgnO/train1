package com.example.demo.controller;

import com.example.demo.model.RedisModel;
import com.example.demo.service.IRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mango
 */
@RestController
public class RedisControllerTest {
    private final IRedisService redisService;

    @Autowired
    public RedisControllerTest(IRedisService redisService) {
        this.redisService = redisService;
    }

    @RequestMapping("/add")
    public void add() {
        System.out.println("start.....");
        RedisModel m = new RedisModel();
        m.setName("张三");
        m.setTel("1111");
        m.setAddress("深圳1");
        m.setRedisKey("zhangsanKey01");
        redisService.put(m.getRedisKey(), m, -1);

        RedisModel m2 = new RedisModel();
        m2.setName("张三2");
        m2.setTel("2222");
        m2.setAddress("深圳2");
        m2.setRedisKey("zhangsanKey02");
        redisService.put(m2.getRedisKey(), m2, -1);

        RedisModel m3 = new RedisModel();
        m3.setName("张三3");
        m3.setTel("2222");
        m3.setAddress("深圳2");
        m3.setRedisKey("zhangsanKey03");
        redisService.put(m3.getRedisKey(), m3, -1);

        System.out.println("add success end...");
    }
}
