package com.example.demo.json.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;

import java.io.IOException;
import java.util.Optional;

/**
 * @package: com.example.demo.json.jackson
 * @author:
 * @email:
 * @createDate: 2019-06-05 15:41
 * @description:
 */
public class UsingOptionalWithJackson {
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private class Book {
        String title;
        Optional<String> subTitle;
    }

    @Test
    public void test1() throws JsonProcessingException {
        Book book = new Book();
        book.setTitle("Oliver Twist");
        book.setSubTitle(Optional.of("The Parish Boy's Progress"));

        ObjectMapper objectMapper = new ObjectMapper();
        String result = objectMapper.writeValueAsString(book);
        System.out.println(result);

    }

    /*
     * This behavior again makes sense. Essentially, Jackson needs a constructor which can take the
     * value of subtitle as an argument. This is not the case with our Optional field.
     * */
    @Test
    public void test2() throws IOException {
        String bookJson = "{\"title\":\"Oliver Twist\",\"subTitle\":{\"present\":true}}";

        ObjectMapper objectMapper = new ObjectMapper();
        Book book = objectMapper.readValue(bookJson, Book.class);

        System.out.println(book);
    }

    @Test
    public void test3() throws JsonProcessingException {
        Book book = new Book();
        book.setTitle("Oliver Twist");
        book.setSubTitle(Optional.of("The Parish Boy's Progress"));

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new Jdk8Module());
        String result = objectMapper.writeValueAsString(book);
        System.out.println(result);

        /*assertThat(from(result).getString("subTitle"))
                .isEqualTo("The Parish Boy's Progress");*/
    }

    @Test
    public void test4() throws IOException {
        String bookJson = "{\"title\":\"Oliver Twist\",\"subTitle\":\"The Parish Boy's Progress\"}";

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new Jdk8Module());
        Book book = objectMapper.readValue(bookJson, Book.class);

        System.out.println(book);
    }
}
