package com.example.demo.service;

import com.example.demo.model.TimeDimension;

import java.util.List;

/**
 * @Package: com.example.demo.service
 * @Author:
 * @Email:
 * @CreateDate: 2019-05-23 13:35
 * @Description:
 */
public interface TimeDimensionService {
    List<TimeDimension> findAllTimeDimension();

    TimeDimension findTimeDimensionById(Integer id);

    Integer updateTimeDimension(Integer id,String event);
}
