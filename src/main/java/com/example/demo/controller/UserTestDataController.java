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

import javax.annotation.Resource;
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
    @Resource
    private UserTestDataService userTestDataService;

    /**
     * 分页查询user
     * @return JsonResult
     */
    @GetMapping
    @PageHelp
    public JsonResult findAllUsers() {
        List<UserTestData> allUsers = userTestDataService.findAllUsers();
        return new JsonResult(allUsers);
    }

    /**
     * 分页查询user
     * @return JsonResult
     */
    @GetMapping("/list")
    @PageHelp
    public JsonResult findAllUsersV3() {
        List<UserTestData> list1 = userTestDataService.list();
        return new JsonResult(list1);
    }

    /**
     * 分局id查询user
     * @return JsonResult
     */
    @GetMapping("/{id}")
    public JsonResult selectById(@PathVariable("id") Integer id) {
        UserTestData userTestData = userTestDataService.selectById(id);
        return new JsonResult(userTestData);
    }
}
