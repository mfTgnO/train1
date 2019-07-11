package com.example.demo.collections.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @package: com.example.demo.collections.model
 * @author:
 * @email:
 * @createDate: 2019-06-05 10:51
 * @description:
 */
public class EventFormat {
    public String name;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    public Date eventDate;

    public EventFormat(String name, Date eventDate) {
        this.name = name;
        this.eventDate = eventDate;
    }
}
