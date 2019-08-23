package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.model.Province;
import com.example.demo.service.ProvinceService;
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
import java.io.IOException;
import java.util.List;

import static com.example.demo.config.RedisKeyPrefix.PROVINCE;


/**
 * @package: com.example.demo.controller
 * @author:
 * @email:
 * @createDate: 2019-08-01 11:56
 * @description:
 */
@RestController
@RequestMapping(("/api/province"))
public class ProvinceController {
    private ProvinceService provinceService;
    private RedisTemplate<String, String> redisTemplate;
    private ValueOperations<String, String> valueOperations;

    @Autowired
    public ProvinceController(RedisTemplate<String, String> redisTemplate, ProvinceService provinceService) {
        this.redisTemplate = redisTemplate;
        this.provinceService = provinceService;
    }

    @PostConstruct
    protected void init() {
        this.valueOperations = redisTemplate.opsForValue();
    }

    /**
     * 分页查询省份
     *
     * @return JsonResult
     */
    @GetMapping("/list")
    @PageHelp
    public JsonResult listProvince() {
        List<Province> list = provinceService.list(null);
        return new JsonResult(list);
    }

    @GetMapping
    public JsonResult getProvince(@RequestParam Integer id) throws IOException {
        Province province = null;
        String json = valueOperations.get(PROVINCE.getPrefix() + id);
        if (json != null) {
            province = new ObjectMapper().readerFor(Province.class)
                    .readValue(json);
        }
        if (province == null) {
            QueryWrapper<Province> qw = new QueryWrapper<>();
            qw.lambda().eq(Province::getId, id);
            province = provinceService.getOne(qw);
            valueOperations.set(PROVINCE.getPrefix() + id, new ObjectMapper().writeValueAsString(province));
        }
        return new JsonResult(province);
    }

    /**
     * 查询所有记录
     *
     * @return JsonResult
     */
    @GetMapping("/listAll")
    public JsonResult listAllProvince() {
        List<Province> list = provinceService.list();
        return new JsonResult(list);
    }

    /**
     * 查询总条数
     *
     * @return JsonResult
     */
    @GetMapping("/count")
    public JsonResult countProvince() {
        int count = provinceService.count();
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
        int count = provinceService.count();
        int allPage = count / 10 + 1;

        for (int current = 0; current < allPage; ) {
            current++;
            Page<Province> page = new Page<>(current, 10);
            IPage<Province> page1 = provinceService.page(page);
            List<Province> records = page1.getRecords();
            for (Province province : records) {
                valueOperations.set(PROVINCE.getPrefix() + province.getId(), new ObjectMapper().writeValueAsString(province));
            }
        }
        return new JsonResult();
    }
}
