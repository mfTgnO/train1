package com.example.demo.service.impl;

import com.example.demo.domain.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Package: com.example.demo.service.impl
 * @Author:
 * @Email:
 * @CreateDate: 2019-05-23 12:51
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {
    private UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public List<User> findAllUsers() {
        return userMapper.findAllUsers();
    }

    @Override
    public User findUserById(Integer id) {
        return userMapper.findUserById(id);
    }

    @Transactional
    @Override
    public Integer insertUser(User user) {
        return userMapper.insertUser(user);
    }

    @Transactional(rollbackFor = {RuntimeException.class})
    @Override
    public Integer insertUserExceptionV1(User user) {
        Integer effectRow = userMapper.insertUser(user);
        System.out.println("====================================================================");
        System.out.println("effectRow:" + effectRow);

        String str = null;
        System.out.println(str.length());

        return effectRow;
    }

    @Transactional(rollbackFor = {RuntimeException.class})
    @Override
    public void insertUserExceptionV2(User user) throws Exception {
        Integer effectRow = userMapper.insertUser(user);
        System.out.println("====================================================================");
        System.out.println("effectRow:" + effectRow);

        throw new Exception("this is checked exception throwing intentinally");
    }

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void insertUserExceptionV3(User user) throws Exception {
        Integer effectRow = userMapper.insertUser(user);
        System.out.println("====================================================================");
        System.out.println("effectRow:" + effectRow);
        System.out.println(user);

//        throw new Exception("this is checked exception throwing intentinally");
    }
}