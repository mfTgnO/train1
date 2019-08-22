package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

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

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUser() {
        List<User> allUsers = userService.findAllUsers();
        System.out.println("==================================================================");
        System.out.println(allUsers);
        return allUsers;
    }

    @GetMapping("/findUser")
    public User findUserById(@RequestParam("id") Integer id) {
        User user = userService.findUserById(id);
        System.out.println("==================================================================");
        System.out.println(user);
        return user;
    }

    @GetMapping("/findUserV2")
    public User findUserByIdV2(@RequestParam("id") Integer id) throws ExecutionException, InterruptedException {
        CompletableFuture<User> userCompletableFuture = new CompletableFuture<>();
        new Thread(() -> {
            User user = userService.findUserById(id);
            userCompletableFuture.complete(user);
        }).start();
        User user = userCompletableFuture.get();
        System.out.println("==================================================================");
        System.out.println(user);
        return user;
    }

    /*@GetMapping("/findUserV3")
    public User findUserByIdV3(@RequestParam("id") Integer id) throws ExecutionException, InterruptedException {
//        CompletableFuture<User> userCompletableFuture = new CompletableFuture<>();
        U u = CompletableFuture.supplyAsync(userService.findUserById(id), EXECUTOR2)
                .get();
        *//*new Thread(() -> {
            User user = userService.findUserById(id);
            userCompletableFuture.complete(user);
        }).start();*//*
        User user = userCompletableFuture.get();
        System.out.println("==================================================================");
        System.out.println(user);
        return user;
    }*/

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

    /**
     * 返回主键id
     *
     * @param name
     * @param email
     * @throws Exception
     */
    @PostMapping("/addExceptionV3")
    public void addUserExceptionV3(@RequestParam("name") String name, @RequestParam("email") String email) throws Exception {
        User user = new User();
        user.setName(name);
        user.setEmail(email);

        userService.insertUserExceptionV3(user);
//        throw new Exception("this is checked exception throwing intentinally");
    }
}
