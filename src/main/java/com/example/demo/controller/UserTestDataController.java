package com.example.demo.controller;

import com.example.demo.model.UserTestData;
import com.example.demo.service.UserTestDataService;
import com.example.demo.utils.JsonResult;
import com.example.demo.utils.annotation.PageHelp;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @package: com.example.demo.controller
 * @author:
 * @email:
 * @createDate: 2019-06-13 14:03
 * @description:
 */
@RestController
@RequestMapping("/userTest")
public class UserTestDataController {
    private UserTestDataService userTestDataService;

    @Autowired
    public UserTestDataController(UserTestDataService userTestDataService) {
        this.userTestDataService = userTestDataService;
    }

    @GetMapping
    @PageHelp
    public JsonResult findAllUsers() {
        PageHelper.startPage(2, 10);
        List<UserTestData> allUsers = userTestDataService.findAllUsers();
        PageInfo<UserTestData> userTestDataPageInfo = new PageInfo<>(allUsers);
        return new JsonResult(userTestDataPageInfo);
    }

    @GetMapping("/v2/list")
    @PageHelp
    public JsonResult findAllUsersV2() {
        List<UserTestData> list = userTestDataService.findAllUsers();
        return new JsonResult(list);
    }

    @GetMapping("/{id}")
    public JsonResult selectById(@PathVariable("id") Integer id) {
        UserTestData userTestData = userTestDataService.selectById(id);
        return new JsonResult(userTestData);
    }
}
