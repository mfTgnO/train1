package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.model.UserTestData;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @package: com.example.demo.mapper
 * @author:
 * @email:
 * @createDate: 2019-06-13 13:53
 * @description:
 */
public interface UserTestDataMapper extends BaseMapper<UserTestData> {
    List<UserTestData> findAllUser();
}
