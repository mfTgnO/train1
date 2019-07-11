package com.example.demo.service.impl;

import com.example.demo.model.RedisModel;
import com.example.demo.service.IRedisService;
import org.springframework.stereotype.Service;

/**
 * @author mango
 */
@Service
public class RedisServiceImpl extends IRedisService<RedisModel> {
    private static final String REDIS_KEY = "TEST_REDIS_KEY";

    @Override
    protected String getRedisKey() {
        return REDIS_KEY;
    }
}
