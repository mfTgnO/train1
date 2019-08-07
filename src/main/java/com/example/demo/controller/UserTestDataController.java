package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.model.UserTestData;
import com.example.demo.service.UserTestDataService;
import com.example.demo.utils.JsonResult;
import com.example.demo.utils.annotation.PageHelp;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

import static com.example.demo.config.RedisConfig.redisKeyPrefix.USER;

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
    private RedisTemplate<String, String> redisTemplate;
    private ValueOperations<String, String> valueOperations;

    @Autowired
    public UserTestDataController(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    protected void init() {
        this.valueOperations = redisTemplate.opsForValue();
    }

    @Resource
    private UserTestDataService userTestDataService;

    /**
     * 分页查询user
     *
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
     *
     * @return JsonResult
     */
    @GetMapping("/list")
    @PageHelp
    public JsonResult findAllUsersV3() {
        List<UserTestData> list1 = userTestDataService.list();
        return new JsonResult(list1);
    }

    /**
     * 根据id查询user
     *
     * @return JsonResult
     */
    @GetMapping("/{id}")
    public JsonResult selectById(@PathVariable("id") Integer id) {
        UserTestData userTestData = userTestDataService.selectById(id);
        return new JsonResult(userTestData);
    }

    /**
     * 根据id查询user，先从redis中获取
     *
     * @return JsonResult
     */
    @GetMapping("/v1/{id}")
    public JsonResult selectByIdFromRedis(@PathVariable("id") Integer id) throws IOException {
        UserTestData userTestData = null;
        String json = valueOperations.get(USER.getPrefix() + id);
        if (json != null) {
            userTestData = new ObjectMapper().readerFor(UserTestData.class)
                    .readValue(json);
        }
        if (userTestData == null) {
            QueryWrapper<UserTestData> qw = new QueryWrapper<>();
            qw.lambda().eq(UserTestData::getId, id);
            userTestData = userTestDataService.getOne(qw);
            valueOperations.set(USER.getPrefix() + id, new ObjectMapper().writeValueAsString(userTestData));
        }
        return new JsonResult(userTestData);
    }

    /**
     * 查询总条数
     *
     * @return JsonResult
     */
    @GetMapping("/count")
    public JsonResult countProvince() {
        int count = userTestDataService.count();
        return new JsonResult(count);
    }


    /**
     * 把所有数据存入Redis
     *
     * @return JsonResult
     * @throws JsonProcessingException
     */
    @GetMapping("/storeRedis")
    public JsonResult pageProvince() throws JsonProcessingException {
        int count = userTestDataService.count();
        int allPage = count / 1000 + 1;

        for (int current = 215; current < allPage; ) {
            current++;
            IPage<UserTestData> page = userTestDataService.page(new Page<>(current, 1000));
            List<UserTestData> records = page.getRecords();
            for (UserTestData userTestData : records) {
                valueOperations.set(USER.getPrefix() + userTestData.getId(), new ObjectMapper().writeValueAsString(userTestData));
            }
        }
        return new JsonResult();
    }
}
