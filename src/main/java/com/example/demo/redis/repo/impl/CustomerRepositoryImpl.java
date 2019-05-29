package com.example.demo.redis.repo.impl;

import com.example.demo.redis.model.Customer;
import com.example.demo.redis.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

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

    @Override
    public void save(Customer customer) {
        hashOperations.put(KEY, customer.getId(), customer);
    }

    @Override
    public Customer find(Long id) {
        return hashOperations.get(KEY, id);
    }

    @Override
    public Map<Long, Customer> findAll() {
        return hashOperations.entries(KEY);
    }

    @Override
    public void update(Customer customer) {
        hashOperations.put(KEY, customer.getId(), customer);
    }

    @Override
    public void delete(Long id) {
        hashOperations.delete(KEY, id);
    }

    @Override
    public void valueOperationsAdd(String key, String value) {
        valueOperations.set(key, value);
    }

    @Override
    public void valueOperationsAddExpireTime(String key, Object value) {
        valueOperations.set(key, value, 10, TimeUnit.SECONDS);
    }

    @Override
    public Object valueOperationsGet(String key) {
        // school:1
        return valueOperations.get(key);
    }

    @Override
    public Long valueOperationsIncrement(String key) {
        return valueOperations.increment(key);
    }

    @Override
    public Long listOperationsRightPush(String key) {
        return listOperations.rightPush(key, UUID.randomUUID());
    }

    @Override
    public List<Object> listOperationsRange(String key) {
        return listOperations.range(key, 0, -1);
    }

    @Override
    public Long listOperationsSize(String key) {
        return listOperations.size(key);
    }

    @Override
    public Object listOperationsLeftPop(String key) {
        return listOperations.leftPop(key);
    }

    @Override
    public Long setOperationsAdd(String key, Object value) {
        return setOperations.add(key, value);
    }

    @Override
    public Set<Object> setOperationsMembers(String key) {
        return setOperations.members(key);
    }

    @Override
    public Long setOperationsSize(String key) {
        return setOperations.size(key);
    }
}
