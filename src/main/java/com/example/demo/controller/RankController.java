package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.model.Rank;
import com.example.demo.service.RankService;
import com.example.demo.utils.JsonResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

/**
 * @package: com.example.demo.controller
 * @author:
 * @email:
 * @createDate: 2019-07-12 15:58
 * @description:
 */
@RestController
@RequestMapping("/api/rank")
public class RankController {
    @Resource
    private RankService rankService;

    /**
     * 根据id查找匹配的行
     *
     * @param id id
     * @return JsonResult
     */
    @GetMapping
    public JsonResult listById(@RequestParam(value = "id") Integer id) {
        QueryWrapper<Rank> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(Rank::getPid, id);
        Rank rank = rankService.getOne(queryWrapper);

        return new JsonResult(rank);
    }

    /**
     * 根据id查找不匹配的行
     *
     * @param id
     * @return JsonResult
     */
    @GetMapping("/notEqual")
    public JsonResult listByNotEqualId(@RequestParam(value = "id") Integer id) {
        QueryWrapper<Rank> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(false, Rank::getPid, id);
        List<Rank> list = rankService.list(queryWrapper);

        return new JsonResult(list);
    }

    @GetMapping("/list")
    public JsonResult list() {
        List<Rank> list = rankService.list(null);
        System.out.println(list);
        return new JsonResult(list);
    }

    @PostMapping
    public JsonResult insert(@ModelAttribute Rank rank) {
        boolean save = rankService.save(rank);
        if (save) {
            return new JsonResult();
        }
        return new JsonResult.Builder().build(JsonResult.Code.FAIL);
    }

    /**
     * 根据 ID 删除
     *
     * @param id 主键ID
     */
    @DeleteMapping
    public JsonResult removeById(@RequestParam(value = "id") Integer id) {
        boolean remove = rankService.removeById(id);
        if (remove) {
            return new JsonResult();
        }
        return new JsonResult.Builder().build(JsonResult.Code.FAIL);
    }

    /**
     * 根据姓名删除
     */
    @DeleteMapping("/name")
    public JsonResult removeByName(@RequestParam(value = "name") String name) {
        Map<String, Object> map = new HashMap<>(1);
        map.put("name", name);
        boolean remove = rankService.removeByMap(map);
        if (remove) {
            return new JsonResult();
        }
        return new JsonResult.Builder().build(JsonResult.Code.FAIL);
    }

    /**
     * 根据 entity 条件，删除记录
     */
    @DeleteMapping("/ageAndGroupId")
    public JsonResult removeByAgeAndGroupId(@RequestParam(value = "age") String age,
                                            @RequestParam(value = "groupId") String groupId) {
        QueryWrapper<Rank> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("age", age);
        queryWrapper.eq("groupid", groupId);

        boolean remove = rankService.remove(queryWrapper);

        if (remove) {
            return new JsonResult();
        }
        return new JsonResult.Builder().build(JsonResult.Code.FAIL);
    }

    /**
     * 删除（根据ID 批量删除）
     */
    @DeleteMapping("/ids")
    public JsonResult removeByIds(@RequestParam(value = "ids") String ids) {
        List<String> list = Arrays.asList(ids.split(","));

        boolean remove = rankService.removeByIds(list);

        if (remove) {
            return new JsonResult();
        }
        return new JsonResult.Builder().build(JsonResult.Code.FAIL);
    }

    /**
     * 查询（根据ID 批量查询）
     */
    @GetMapping("/ids")
    public JsonResult listByIds(@RequestParam(value = "ids") String ids) {
        List<String> list = Arrays.asList(ids.split(","));

        Collection<Rank> ranks = rankService.listByIds(list);

        return new JsonResult(ranks);
    }

    /**
     * 查询（根据 columnMap 条件）
     */
    @GetMapping("/age")
    public JsonResult listByAge(@RequestParam(value = "age") Integer age) {
        Map<String, Object> map = new HashMap<>(1);
        map.put("age", age);

        Collection<Rank> ranks = rankService.listByMap(map);

        return new JsonResult(ranks);
    }

    /**
     * 查询总记录数
     */
    @GetMapping("/count")
    public JsonResult count() {
        int count = rankService.count();
        JsonResult<Object> jsonResult = new JsonResult<>();
        jsonResult.setCount(count);
        return jsonResult;
    }

    /**
     * 根据 Wrapper 条件，查询总记录数
     */
    @GetMapping("/countByAge")
    public JsonResult countByAge(@RequestParam(value = "age") Integer age) {
        QueryWrapper<Rank> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("age", age);
        int count = rankService.count(queryWrapper);

        JsonResult<Object> jsonResult = new JsonResult<>();
        jsonResult.setCount(count);
        return jsonResult;
    }
}
