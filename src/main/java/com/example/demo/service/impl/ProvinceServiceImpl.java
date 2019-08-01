package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.mapper.ProvinceMapper;
import com.example.demo.model.Province;
import com.example.demo.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @package: com.example.demo.service.impl
 * @author:
 * @email:
 * @createDate: 2019-08-01 11:57
 * @description:
 */
@Service
public class ProvinceServiceImpl extends ServiceImpl<ProvinceMapper, Province> implements ProvinceService {
    private ProvinceMapper provinceMapper;

    @Autowired
    public ProvinceServiceImpl(ProvinceMapper provinceMapper) {
        this.provinceMapper = provinceMapper;
    }
}
