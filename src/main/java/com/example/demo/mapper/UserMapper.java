package com.example.demo.mapper;

import com.example.demo.domain.User;

import java.util.List;

/**
 * @Package: com.example.demo.mapper
 * @Author:
 * @Email:
 * @CreateDate: 2019-05-10 17:29
 * @Description:
 */
public interface UserMapper {
    void insertUser(User user);

    User findUserById(Integer id);

    List<User> findAllUsers();
}
