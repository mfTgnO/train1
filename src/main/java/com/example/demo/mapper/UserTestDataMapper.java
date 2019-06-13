package com.example.demo.mapper;

import com.example.demo.domain.UserTestData;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @package: com.example.demo.mapper
 * @author:
 * @email:
 * @createDate: 2019-06-13 13:53
 * @description:
 */
@Repository
public interface UserTestDataMapper {
    List<UserTestData> findAllUsersV1();

    List<UserTestData> findAllUsersV2();
}
