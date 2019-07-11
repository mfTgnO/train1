package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.service.BookServoce;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @package: com.example.demo.controller
 * @author:
 * @email:
 * @createDate: 2019-05-23 17:56
 * @description:
 */
@RestController
@RequestMapping("/book")
public class BookController {
    private BookServoce bookServoce;

    public BookController(BookServoce bookServoce) {
        this.bookServoce = bookServoce;
    }

    @GetMapping("/all")
    public List<Book> selectAllBook() {
        return bookServoce.selectAllBook();
    }
}
