package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.mapper.CountryMapper;
import com.example.demo.model.Country;
import com.example.demo.service.CountryService;
import org.springframework.stereotype.Service;

/**
 * @package: com.example.demo.service.impl
 * @author:
 * @email:
 * @createDate: 2019-07-30 16:20
 * @description:
 */
@Service
public class CountryServiceImpl extends ServiceImpl<CountryMapper, Country> implements CountryService {
}
