package com.example.demo.collections.domain;

import com.fasterxml.jackson.annotation.JacksonInject;
import lombok.ToString;

/**
 * @package: com.example.demo.collections.domain
 * @author:
 * @email:
 * @createDate: 2019-06-04 17:54
 * @description:
 */
@ToString
public class BeanWithInject {
    @JacksonInject
    public int id;
    public String name;
}
