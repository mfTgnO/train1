package com.example.demo.mappers;

import com.example.demo.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Package: com.example.demo.mappers
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
