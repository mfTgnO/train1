package com.example.demo.dao.impl;

import com.example.demo.dao.CustomerRepository;
import com.example.demo.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author mango
 */
@Repository
public class CustomerRepositoryImpl implements CustomerRepository {
    private static final String KEY = "Customer";
    private static final String REDIS_KEY_USER = "user:";
    private RedisTemplate redisTemplate;

    @Autowired
    public CustomerRepositoryImpl(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }


    /**
     * 添加、更新
     */
    @Override
    public void save(Customer customer) {
        redisTemplate.opsForHash().put(KEY, REDIS_KEY_USER + customer.getId(), customer);
    }

    /**
     * 通过key获取数据
     *
     * @param id key
     * @return Customer
     */
    @Override
    public Customer find(Long id) {
        return (Customer) redisTemplate.opsForHash().get(KEY, REDIS_KEY_USER + id);
    }

    /**
     * hash查询所有
     *
     * @return
     */
    @Override
    public Map<Object, Object> findAll() {
        return redisTemplate.opsForHash().entries(KEY);
    }

    /**
     * 根据key更新
     *
     * @param customer
     */
    @Override
    public void update(Customer customer) {
        redisTemplate.opsForHash().put(KEY, customer.getId(), customer);
    }

    /**
     * hash根据key删除
     *
     * @param id key
     */
    @Override
    public void delete(Long id) {
        redisTemplate.opsForHash().delete(KEY, id);
    }

    /**
     * value类型，添加、更新
     *
     * @param key
     * @param value
     */
    @Override
    public void valueOperationsAdd(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * value类型，添加、更新；设置过期时间
     *
     * @param key
     * @param value
     */
    @Override
    public void valueOperationsAddExpireTime(String key, String value) {
        redisTemplate.opsForValue().set(key, value, 10, TimeUnit.SECONDS);
    }

    /**
     * 通过key查询
     *
     * @param key
     * @return
     */
    @Override
    public Object valueOperationsGet(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * 加1
     *
     * @param key
     * @return
     */
    @Override
    public Long valueOperationsIncrement(String key) {
        return redisTemplate.opsForValue().increment(key);
    }

    /**
     * list类型，从右边push
     *
     * @param key
     * @return
     */
    @Override
    public Long listOperationsRightPush(String key) {
        return redisTemplate.opsForList().rightPush(key, String.valueOf(UUID.randomUUID()));
    }

    /**
     * list类型，指定范围查询
     *
     * @param key
     * @return
     */
    @Override
    public List<String> listOperationsRange(String key) {
        return redisTemplate.opsForList().range(key, 0, -1);
    }

    /**
     * list类型，查询list大小
     *
     * @param key
     * @return
     */
    @Override
    public Long listOperationsSize(String key) {
        return redisTemplate.opsForList().size(key);

    }

    /**
     * list类型，去除左边第一个元素
     *
     * @param key
     * @return
     */
    @Override
    public Object listOperationsLeftPop(String key) {
        return redisTemplate.opsForList().leftPop(key);
    }

    /**
     * set类型，添加
     *
     * @param key
     * @param value
     * @return
     */
    @Override
    public Long setOperationsAdd(String key, String value) {
        return redisTemplate.opsForSet().add(key, value);
    }

    /**
     * set类型，根据key查找元素
     *
     * @param key
     * @return
     */
    @Override
    public Set<String> setOperationsMembers(String key) {
        return redisTemplate.opsForSet().members(key);
    }

    /**
     * set类型，查看集合大小
     *
     * @param key
     * @return
     */
    @Override
    public Long setOperationsSize(String key) {
        return redisTemplate.opsForSet().size(key);
    }
}
