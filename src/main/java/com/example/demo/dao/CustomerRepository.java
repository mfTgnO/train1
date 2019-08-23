package com.example.demo.dao;


import com.example.demo.model.Customer;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author mango
 */
public interface CustomerRepository {
    void save(Customer customer);

    Customer find(Long id);

    Map<Object, Object> findAll();

    void update(Customer customer);

    void delete(Long id);

    void valueOperationsAdd(String key, String value);

    void valueOperationsAddExpireTime(String key, String value);

    Object valueOperationsGet(String key);

    Long valueOperationsIncrement(String key);

    Long listOperationsRightPush(String key);

    List<String> listOperationsRange(String key);

    Long listOperationsSize(String key);

    Object listOperationsLeftPop(String key);

    Long setOperationsAdd(String key, String value);

    Set<String> setOperationsMembers(String key);

    Long setOperationsSize(String key);
}
