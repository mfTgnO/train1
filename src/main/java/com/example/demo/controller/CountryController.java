package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.model.Country;
import com.example.demo.service.CountryService;
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
 * @createDate: 2019-07-30 16:17
 * @description:
 */
@RestController
@RequestMapping("/api/country")
public class CountryController {
    private CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
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
}
