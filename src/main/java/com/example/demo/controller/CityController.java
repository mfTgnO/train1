package com.example.demo.controller;

import com.example.demo.model.City;
import com.example.demo.service.CityService;
import com.example.demo.utils.JsonResult;
import com.example.demo.utils.annotation.PageHelp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/list")
    @PageHelp
    public JsonResult listCity() {
        List<City> list = cityService.list();
        return new JsonResult(list);
    }
}
