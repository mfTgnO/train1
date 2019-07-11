package com.example.demo.mapper;

import com.example.demo.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Package: com.example.demo.mapper
 * @Author:
 * @Email:
 * @CreateDate: 2019-05-10 17:29
 * @Description:
 */
@Repository
public interface UserMapper {
    Integer insertUser(User user);

    User findUserById(Integer id);

    List<User> findAllUsers();
}