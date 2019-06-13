package com.example.demo;

import com.example.demo.domain.User;
import com.example.demo.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class SpringbootMyBatisDemoApplicationTests {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void findAllUsers() {
        List<User> users = userMapper.findAllUsers();

        users.forEach(System.out::println);

        assertNotNull(users);
        assertFalse(users.isEmpty());
    }

    @Test
    public void findUserById() {
        User user = userMapper.findUserById(1);
        System.out.println(user);

        assertNotNull(user);
    }

    @Test
    public void createUser() {
        User user = new User(4, "Siva", "siva@gmail.com");

        userMapper.insertUser(user);
        User newUser = userMapper.findUserById(user.getId());
        System.out.println(newUser);

        assertEquals("Siva", newUser.getName());
        assertEquals("siva@gmail.com", newUser.getEmail());
    }
}