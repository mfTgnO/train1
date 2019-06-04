package com.example.demo.spring.aop.business;

import com.example.demo.spring.aop.TrackTime;
import com.example.demo.spring.aop.data.Dao1;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @package: com.example.demo.spring.aop.business
 * @author:
 * @email:
 * @createDate: 2019-06-03 17:01
 * @description:
 */
@Service
@Slf4j
public class Business1 {
    private Dao1 dao1;

    @Autowired
    public Business1(Dao1 dao1) {
        this.dao1 = dao1;
    }

    @TrackTime
    public String calculateSomething() {
        String value = dao1.retrieveSomething();
        log.info("In Business - {}", value);
        return value;
    }
}
