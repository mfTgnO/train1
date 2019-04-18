package com.example.demo.redis.service.impl;

import com.example.demo.redis.model.RedisModel;
import com.example.demo.redis.service.IRedisService;
import org.springframework.stereotype.Service;

@Service
public class RedisServiceImpl extends IRedisService<RedisModel> {
    private static final String REDIS_KEY = "TEST_REDIS_KEY";

    @Override
    protected String getRedisKey() {
        return REDIS_KEY;
    }
}
