package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.model.Rank;
import io.lettuce.core.dynamic.annotation.Param;

/**
 * @package: com.example.demo.dao
 * @author:
 * @email:
 * @createDate: 2019-07-12 16:13
 * @description:
 */
public interface RankMapper extends BaseMapper<Rank> {
    Rank selectByIdCustomer(@Param("id") Integer id);
}
