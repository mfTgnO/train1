package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.model.Town;
import com.example.demo.service.TownService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;

import static com.example.demo.config.RedisKeyPrefix.TOWN;


/**
 * @package: com.example.demo.controller
 * @author:
 * @email:
 * @createDate: 2019-08-01 15:08
 * @description:
 */
@RestController
@RequestMapping("/api/town")
public class TownController {
    private TownService townService;
    private RedisTemplate<String, String> redisTemplate;
    private ValueOperations<String, String> valueOperations;

    @Autowired
    public TownController(TownService townService, @Qualifier("cacheRedisTemplate") RedisTemplate<String, String> redisTemplate) {
        this.townService = townService;
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    protected void init() {
        this.valueOperations = redisTemplate.opsForValue();
    }

    @GetMapping
    public JsonResult getTown(@RequestParam Integer id) {
        QueryWrapper<Town> qw = new QueryWrapper<>();
        qw.lambda().eq(Town::getId, id);
        List<Town> list = townService.list(qw);
        return new JsonResult(list);
    }

    @GetMapping("/list")
    @PageHelp
    public JsonResult listTown() {
        List<Town> list = townService.list(null);
        return new JsonResult(list);
    }

    @GetMapping("/listAll")
    @PageHelp
    public JsonResult listAllTown() {
        List<Town> list = townService.list();
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
        int count = townService.count();
        int allPage = count / 10 + 1;

        for (int current = 0; current < allPage; ) {
            current++;
            IPage<Town> page = townService.page(new Page<>(current, 10));
            List<Town> records = page.getRecords();
            for (Town town : records) {
                valueOperations.set(TOWN.getPrefix() + town.getId(), new ObjectMapper().writeValueAsString(town));
            }
        }
        return new JsonResult();
    }
}
