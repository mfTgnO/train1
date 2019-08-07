package com.example.demo.dao.impl;

import com.example.demo.dao.CustomerRepository;
import com.example.demo.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
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
    private RedisTemplate<String, Object> redisTemplate;
    private HashOperations<String, Long, Customer> hashOperations;
    private ValueOperations<String, Object> valueOperations;
    private ListOperations<String, Object> listOperations;
    private SetOperations<String, Object> setOperations;
    private ZSetOperations<String, Object> zSetOperations;


    @Autowired
    public CustomerRepositoryImpl(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    private void init() {
        this.hashOperations = redisTemplate.opsForHash();
        this.valueOperations = redisTemplate.opsForValue();
        this.listOperations = redisTemplate.opsForList();
        this.setOperations = redisTemplate.opsForSet();
        this.zSetOperations = redisTemplate.opsForZSet();
    }

    /**
     * 添加、更新
     */
    @Override
    public void save(Customer customer) {
        hashOperations.put(KEY, customer.getId(), customer);
    }

    /**
     * 通过key获取数据
     *
     * @param id key
     * @return Customer
     */
    @Override
    public Customer find(Long id) {
        return hashOperations.get(KEY, id);
    }

    /**
     * hash查询所有
     *
     * @return
     */
    @Override
    public Map<Long, Customer> findAll() {
        return hashOperations.entries(KEY);
    }

    /**
     * 根据key更新
     *
     * @param customer
     */
    @Override
    public void update(Customer customer) {
        hashOperations.put(KEY, customer.getId(), customer);
    }

    /**
     * hash根据key删除
     *
     * @param id key
     */
    @Override
    public void delete(Long id) {
        hashOperations.delete(KEY, id);
    }

    /**
     * value类型，添加、更新
     *
     * @param key
     * @param value
     */
    @Override
    public void valueOperationsAdd(String key, String value) {
        valueOperations.set(key, value);
    }

    /**
     * value类型，添加、更新；设置过期时间
     *
     * @param key
     * @param value
     */
    @Override
    public void valueOperationsAddExpireTime(String key, Object value) {
        valueOperations.set(key, value, 10, TimeUnit.SECONDS);
    }

    /**
     * 通过key查询
     *
     * @param key
     * @return
     */
    @Override
    public Object valueOperationsGet(String key) {
        return valueOperations.get(key);
    }

    /**
     * 加1
     *
     * @param key
     * @return
     */
    @Override
    public Long valueOperationsIncrement(String key) {
        return valueOperations.increment(key);
    }

    /**
     * list类型，从右边push
     *
     * @param key
     * @return
     */
    @Override
    public Long listOperationsRightPush(String key) {
        return listOperations.rightPush(key, UUID.randomUUID());
    }

    /**
     * list类型，指定范围查询
     *
     * @param key
     * @return
     */
    @Override
    public List<Object> listOperationsRange(String key) {
        return listOperations.range(key, 0, -1);
    }

    /**
     * list类型，查询list大小
     *
     * @param key
     * @return
     */
    @Override
    public Long listOperationsSize(String key) {
        return listOperations.size(key);
    }

    /**
     * list类型，去除左边第一个元素
     *
     * @param key
     * @return
     */
    @Override
    public Object listOperationsLeftPop(String key) {
        return listOperations.leftPop(key);
    }

    /**
     * set类型，添加
     *
     * @param key
     * @param value
     * @return
     */
    @Override
    public Long setOperationsAdd(String key, Object value) {
        return setOperations.add(key, value);
    }

    /**
     * set类型，根据key查找元素
     *
     * @param key
     * @return
     */
    @Override
    public Set<Object> setOperationsMembers(String key) {
        return setOperations.members(key);
    }

    /**
     * set类型，查看集合大小
     *
     * @param key
     * @return
     */
    @Override
    public Long setOperationsSize(String key) {
        return setOperations.size(key);
    }
}
