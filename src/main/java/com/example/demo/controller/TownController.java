package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.model.Town;
import com.example.demo.service.TownService;
import com.example.demo.utils.JsonResult;
import com.example.demo.utils.annotation.PageHelp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @Autowired
    public TownController(TownService townService) {
        this.townService = townService;
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
}
