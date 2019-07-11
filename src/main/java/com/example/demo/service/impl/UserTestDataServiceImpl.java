package com.example.demo.service.impl;

import com.example.demo.model.UserTestData;
import com.example.demo.mapper.UserTestDataMapper;
import com.example.demo.service.UserTestDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @package: com.example.demo.service.impl
 * @author:
 * @email:
 * @createDate: 2019-06-13 13:53
 * @description:
 */
@Service
public class UserTestDataServiceImpl implements UserTestDataService {
    private UserTestDataMapper userTestDataMapper;

    @Autowired
    public UserTestDataServiceImpl(UserTestDataMapper userTestDataMapper) {
        this.userTestDataMapper = userTestDataMapper;
    }

    @Override
    public List<UserTestData> findAllUsers() {
        return userTestDataMapper.findAllUsersV2();
    }
}
