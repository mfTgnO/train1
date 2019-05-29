package com.example.demo.redis.repo;

import com.example.demo.redis.model.Customer;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface CustomerRepository {
    void save(Customer customer);

    Customer find(Long id);

    Map<Long, Customer> findAll();

    void update(Customer customer);

    void delete(Long id);

    void valueOperationsAdd(String key, String value);

    void valueOperationsAddExpireTime(String key, Object value);

    Object valueOperationsGet(String key);

    Long valueOperationsIncrement(String key);

    Long listOperationsRightPush(String key);

    List<Object> listOperationsRange(String key);

    Long listOperationsSize(String key);

    Object listOperationsLeftPop(String key);

    Long setOperationsAdd(String key, Object value);

    Set<Object> setOperationsMembers(String key);

    Long setOperationsSize(String key);
}
