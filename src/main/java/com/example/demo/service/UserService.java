package com.example.demo.service;

import com.example.demo.domain.User;

import java.util.List;

/**
 * @Package: com.example.demo.service
 * @Author:
 * @Email:
 * @CreateDate: 2019-05-23 12:50
 * @Description:
 */
public interface UserService {
    List<User> findAllUsers();

    User findUserById(Integer id);

    Integer insertUser(User user);

    Integer insertUserExceptionV1(User user);

    void insertUserExceptionV2(User user) throws Exception;

    void insertUserExceptionV3(User user) throws Exception;
}
