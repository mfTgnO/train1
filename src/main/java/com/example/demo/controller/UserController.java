package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Package: com.example.demo.controller
 * @Author:
 * @Email:
 * @CreateDate: 2019-05-23 12:53
 * @Description:
 */
@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUser() {
        return userService.findAllUsers();
    }

    @GetMapping("/findUser")
    public User findUserById(@RequestParam("id") Integer id) {
        return userService.findUserById(id);
    }

    @PostMapping("/add")
    public void addUser(@RequestParam("name") String name, @RequestParam("email") String email) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);

        Integer effectRow = userService.insertUser(user);
        System.out.println("effectRow:" + effectRow);
    }

    @PostMapping("/addExceptionV1")
    public void addUserExceptionV1(@RequestParam("name") String name, @RequestParam("email") String email) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);

        Integer effectRow = userService.insertUserExceptionV1(user);
        System.out.println("effectRow:" + effectRow);
    }

    @PostMapping("/addExceptionV2")
    public void addUserExceptionV2(@RequestParam("name") String name, @RequestParam("email") String email) throws Exception {
        User user = new User();
        user.setName(name);
        user.setEmail(email);

        userService.insertUserExceptionV2(user);
    }

    @PostMapping("/addExceptionV3")
    public void addUserExceptionV3(@RequestParam("name") String name, @RequestParam("email") String email) throws Exception {
        User user = new User();
        user.setName(name);
        user.setEmail(email);

        userService.insertUserExceptionV3(user);
    }
}
