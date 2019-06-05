package com.example.demo.json.jackson;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @package: com.example.demo.json.jackson
 * @author:
 * @email:
 * @createDate: 2019-06-05 15:14
 * @description:Next – let’s see how to create a custom Jackson annotation; we can make use of
 * the @JacksonAnnotationsInside annotation – as in the following example:
 */
@Retention(RetentionPolicy.RUNTIME)
@JacksonAnnotationsInside
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"name", "id", "dateCreated"})
public @interface CustomJacksonAnnotation {
}
