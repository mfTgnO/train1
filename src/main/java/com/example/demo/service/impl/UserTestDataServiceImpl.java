package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.mapper.UserTestDataMapper;
import com.example.demo.model.UserTestData;
import com.example.demo.service.UserTestDataService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @package: com.example.demo.service.impl
 * @author:
 * @email:
 * @createDate: 2019-06-13 13:53
 * @description:
 */
@Service
public class UserTestDataServiceImpl extends ServiceImpl<UserTestDataMapper, UserTestData> implements UserTestDataService {
    @Resource
    private UserTestDataMapper userTestDataMapper;

    @Override
    public List<UserTestData> findAllUsers() {
        return userTestDataMapper.findAllUser();
    }

    /**
     * MyBatis-Plus
     *
     * @return
     */
    @Override
    public UserTestData selectById(Integer id) {
        return userTestDataMapper.selectById(id);
    }
}
