package com.example.demo.service.impl;

import com.example.demo.mapper.UserTestDataMapper;
import com.example.demo.mapper.UserTestDataV1Mapper;
import com.example.demo.model.UserTestData;
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
    private UserTestDataV1Mapper userTestDataV1Mapper;

    @Autowired
    public UserTestDataServiceImpl(UserTestDataMapper userTestDataMapper, UserTestDataV1Mapper userTestDataV1Mapper) {
        this.userTestDataMapper = userTestDataMapper;
        this.userTestDataV1Mapper = userTestDataV1Mapper;
    }

    @Override
    public List<UserTestData> findAllUsers() {
        return userTestDataMapper.findAllUsersV2();
    }

    /**
     * MyBatis-Plus
     *
     * @return
     */
    @Override
    public UserTestData selectById(Integer id) {
//        Wrapper wrapper = new Wrapper();
//        List<UserTestData> userTestData = userTestDataV1Mapper.selectList(null);

        return userTestDataMapper.selectById(id);
    }
}
