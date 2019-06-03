package com.example.demo.spring.aop.data;

import org.springframework.stereotype.Repository;

/**
 * @package: com.example.demo.spring.aop.data
 * @author:
 * @email:
 * @createDate: 2019-06-03 17:02
 * @description:
 */
@Repository
public class Dao1 {
    public String retrieveSomething() {
        return "Dao1";
    }
}
