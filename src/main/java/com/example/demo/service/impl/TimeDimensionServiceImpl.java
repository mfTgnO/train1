package com.example.demo.service.impl;

import com.example.demo.model.TimeDimension;
import com.example.demo.mapper.TimeDimensionMapper;
import com.example.demo.service.TimeDimensionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Package: com.example.demo.service.impl
 * @Author:
 * @Email:
 * @CreateDate: 2019-05-23 13:35
 * @Description:
 */
@Service
public class TimeDimensionServiceImpl implements TimeDimensionService {
    private TimeDimensionMapper timeDimensionMapper;

    @Autowired
    public TimeDimensionServiceImpl(TimeDimensionMapper timeDimensionMapper) {
        this.timeDimensionMapper = timeDimensionMapper;
    }

    @Override
    public List<TimeDimension> findAllTimeDimension() {
        return timeDimensionMapper.findAllTimeDimension();
    }

    @Override
    public TimeDimension findTimeDimensionById(Integer id) {
        return timeDimensionMapper.findTimeDimensionById(id);
    }

    @Override
    public Integer updateTimeDimension(Integer id, String event) {
        return timeDimensionMapper.updateTimeDimension(id, event);
    }
}
