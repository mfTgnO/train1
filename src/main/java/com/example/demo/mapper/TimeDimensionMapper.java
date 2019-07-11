package com.example.demo.mapper;

import com.example.demo.model.TimeDimension;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Package: com.example.demo.mapper
 * @Author:
 * @Email:
 * @CreateDate: 2019-05-23 13:30
 * @Description:
 */
@Repository
public interface TimeDimensionMapper {
    /**
     * 根据主键id查询TimeDimension
     *
     * @param id id
     * @return TimeDimension TimeDimension
     */
    TimeDimension findTimeDimensionById(Integer id);

    /**
     * 查询TimeDimension集合
     *
     * @return List<TimeDimension>
     */
    List<TimeDimension> findAllTimeDimension();

    /**
     * 根据主键id更新
     *
     * @param id    id
     * @param event event
     * @return Integer
     */
    Integer updateTimeDimension(Integer id, String event);
}
