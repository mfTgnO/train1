package com.example.demo.spring.aop.business;

import com.example.demo.spring.aop.data.Dao2;
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
public class Business2 {
    private Dao2 dao2;

    @Autowired
    public Business2(Dao2 dao2) {
        this.dao2 = dao2;
    }

    public String calculateSomething() {
        String value = dao2.retrieveSomething();
        log.info("In Business - {}", value);
        return value;
    }
}
