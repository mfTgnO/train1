package com.example.demo.mappers;

import com.example.demo.domain.TimeDimension;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Package: com.example.demo.mappers
 * @Author:
 * @Email:
 * @CreateDate: 2019-05-23 13:30
 * @Description:
 */
@Repository
public interface TimeDimensionMapper {
    TimeDimension findTimeDimensionById(Integer id);

    List<TimeDimension> findAllTimeDimension();

    Integer updateTimeDimension(Integer id, String event);
}
