package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.model.UserTestData;

import java.util.List;

/**
 * @package: com.example.demo.service
 * @author:
 * @email:
 * @createDate: 2019-06-13 13:52
 * @description:
 */
public interface UserTestDataService extends IService<UserTestData> {
    List<UserTestData> findAllUsers();

    UserTestData selectById(Integer id);
}
