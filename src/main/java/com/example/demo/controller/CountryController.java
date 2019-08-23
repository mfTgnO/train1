package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.model.Country;
import com.example.demo.service.CountryService;
import com.example.demo.utils.JsonResult;
import com.example.demo.utils.annotation.PageHelp;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;

import static com.example.demo.config.RedisKeyPrefix.COUNTRY;


/**
 * @package: com.example.demo.controller
 * @author:
 * @email:
 * @createDate: 2019-07-30 16:17
 * @description:
 */
@RestController
@RequestMapping("/api/country")
public class CountryController {
    private CountryService countryService;
    private RedisTemplate<String, String> redisTemplate;
    private ValueOperations<String, String> valueOperations;

    @Autowired
    public CountryController(CountryService countryService, RedisTemplate<String, String> redisTemplate) {
        this.countryService = countryService;
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    protected void init() {
        this.valueOperations = redisTemplate.opsForValue();
    }

    @GetMapping
    public JsonResult getCountry(@RequestParam(value = "id") Integer id) {
        QueryWrapper<Country> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", id);
        Country country = countryService.getOne(queryWrapper);
        return new JsonResult(country);
    }

    @GetMapping("/list")
    @PageHelp
    public JsonResult listCountry() {
        List<Country> list = countryService.list(null);
        return new JsonResult(list);
    }

    @GetMapping("/listAll")
    public JsonResult listAllCountry() {
        List<Country> list = countryService.list();
        return new JsonResult(list);
    }

    /**
     * 把所有数据存入Redis
     *
     * @return JsonResult
     * @throws JsonProcessingException
     */
    @GetMapping("/storeRedis")
    public JsonResult pageProvince() throws JsonProcessingException {
        int count = countryService.count();
        int allPage = count / 10 + 1;

        for (int current = 0; current < allPage; ) {
            current++;
            Page<Country> page = new Page<>(current, 10);
            IPage<Country> page1 = countryService.page(page);
            List<Country> records = page1.getRecords();
            for (Country country : records) {
                valueOperations.set(COUNTRY.getPrefix() + country.getId(), new ObjectMapper().writeValueAsString(country));
            }
        }
        return new JsonResult();
    }
}
