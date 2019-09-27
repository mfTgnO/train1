package com.example.demo.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.model.City;
import com.example.demo.service.CityService;
import com.example.demo.utils.JsonResult;
import com.example.demo.utils.annotation.PageHelp;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;

import static com.example.demo.config.RedisKeyPrefix.CITY;


/**
 * @package: com.example.demo.controller
 * @author:
 * @email:
 * @createDate: 2019-07-30 12:05
 * @description:
 */
@RestController
@RequestMapping("/api/city")
public class CityController {
    private CityService cityService;
    private RedisTemplate<String, String> redisTemplate;
    private ValueOperations<String, String> valueOperations;

    @Autowired
    public CityController(CityService cityService, @Qualifier("cacheRedisTemplate") RedisTemplate<String, String> redisTemplate) {
        this.cityService = cityService;
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    protected void init() {
        this.valueOperations = redisTemplate.opsForValue();
    }

    @GetMapping("/list")
    @PageHelp
    public JsonResult listCity() {
        List<City> list = cityService.list(null);
        return new JsonResult<>(list);
    }

    @GetMapping("/listAll")
    @PageHelp
    public JsonResult listAllCity() {
        List<City> list = cityService.list();
        return new JsonResult<>(list);
    }

    /**
     * 把所有数据存入Redis
     *
     * @return JsonResult
     * @throws JsonProcessingException
     */
    @GetMapping("/storeRedis")
    public JsonResult pageProvince() throws JsonProcessingException {
        int count = cityService.count();
        int allPage = count / 10 + 1;

        for (int current = 0; current < allPage; ) {
            current++;
            Page<City> page = new Page<>(current, 10);
            IPage<City> page1 = cityService.page(page);
            List<City> records = page1.getRecords();
            for (City city : records) {
                valueOperations.set(CITY.getPrefix() + city.getId(), new ObjectMapper().writeValueAsString(city));
            }
        }
        return new JsonResult();
    }
}
