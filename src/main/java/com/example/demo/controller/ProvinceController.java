package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.model.Province;
import com.example.demo.service.ProvinceService;
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
 * @createDate: 2019-08-01 11:56
 * @description:
 */
@RestController
@RequestMapping(("/api/province"))
public class ProvinceController {
    private ProvinceService provinceService;

    @Autowired
    public ProvinceController(ProvinceService provinceService) {
        this.provinceService = provinceService;
    }

    @GetMapping("/list")
    @PageHelp
    public JsonResult listProvince() {
        List<Province> list = provinceService.list(null);
        return new JsonResult(list);
    }

    @GetMapping
    public JsonResult getProvince(@RequestParam Integer id) {
        QueryWrapper<Province> qw = new QueryWrapper<>();
        qw.lambda().eq(Province::getId, id);
        Province province = provinceService.getOne(qw);
        return new JsonResult(province);
    }

    @GetMapping("/listAll")
    public JsonResult listAllProvince() {
        List<Province> list = provinceService.list();
        return new JsonResult(list);
    }
}
