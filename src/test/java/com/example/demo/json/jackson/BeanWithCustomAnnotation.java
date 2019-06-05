package com.example.demo.json.jackson;

import java.util.Date;

/**
 * @package: com.example.demo.json.jackson
 * @author:
 * @email:
 * @createDate: 2019-06-05 15:15
 * @description:
 */
@CustomJacksonAnnotation
public class BeanWithCustomAnnotation {
    public int id;
    public String name;
    public Date dateCreated;

    public BeanWithCustomAnnotation(int id, String name, Date dateCreated) {
        this.id = id;
        this.name = name;
        this.dateCreated = dateCreated;
    }
}
