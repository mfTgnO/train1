package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.mapper.TownMapper;
import com.example.demo.model.Town;
import com.example.demo.service.TownService;
import org.springframework.stereotype.Service;

/**
 * @package: com.example.demo.service.impl
 * @author:
 * @email:
 * @createDate: 2019-08-01 15:07
 * @description:
 */
@Service
public class TownServiceImpl extends ServiceImpl<TownMapper, Town> implements TownService {
}
