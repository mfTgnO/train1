package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public abstract class IRedisService<T> {
    protected RedisTemplate<String, String> redisTemplate;

    private StringRedisTemplate stringRedisTemplate;

    public IRedisService() {
    }

    @Autowired
    public IRedisService(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    @Autowired


    /**
     * 存入redis中的key
     *
     * @return
     */
    protected abstract String getRedisKey();

    /**
     * 添加
     *
     * @param key    key
     * @param doamin 对象
     * @param expire 过期时间(单位:秒),传入 -1 时表示不设置过期时间
     */
    public void put(String key, T doamin, long expire) {
        stringRedisTemplate.opsForHash().put(getRedisKey(), key, doamin);
        if (expire != -1) {
            redisTemplate.expire(getRedisKey(), expire, TimeUnit.SECONDS);
        }
    }

    /**
     * 删除
     *
     * @param key 传入key的名称
     */
    public void remove(String key) {
        stringRedisTemplate.opsForHash().delete(getRedisKey(), key);
    }

    /**
     * 查询
     *
     * @param key 查询的key
     * @return
     */
    public T get(String key) {
        return (T) stringRedisTemplate.opsForHash().get(getRedisKey(), key);
    }

    /**
     * 获取当前redis库下所有对象
     *
     * @return
     */
    public List<T> getAll() {
        return (List<T>) stringRedisTemplate.opsForHash().values(getRedisKey());
    }

    /**
     * 查询查询当前redis库下所有key
     *
     * @return
     */
    public Set<Object> getKeys() {
        return stringRedisTemplate.opsForHash().keys(getRedisKey());
    }

    /**
     * 判断key是否存在redis中
     *
     * @param key 传入key的名称
     * @return
     */
    public boolean isKeyExists(String key) {
        return stringRedisTemplate.opsForHash().hasKey(getRedisKey(), key);
    }

    /**
     * 查询当前key下缓存数量
     *
     * @return
     */
    public long count() {
        return stringRedisTemplate.opsForHash().size(getRedisKey());
    }

    /**
     * 清空redis
     */
    public void empty() {
        Set<Object> set = stringRedisTemplate.opsForHash().keys(getRedisKey());
        set.stream().forEach(key -> stringRedisTemplate.opsForHash().delete(getRedisKey(), key));
    }
}
