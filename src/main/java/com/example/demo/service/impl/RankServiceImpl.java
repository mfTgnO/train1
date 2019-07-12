package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.mapper.RankMapper;
import com.example.demo.model.Rank;
import com.example.demo.service.RankService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @package: com.example.demo.service.impl
 * @author:
 * @email:
 * @createDate: 2019-07-12 15:59
 * @description:
 */
@Service
public class RankServiceImpl extends ServiceImpl<RankMapper, Rank> implements RankService {
    @Resource
    private RankMapper rankMapper;
}
