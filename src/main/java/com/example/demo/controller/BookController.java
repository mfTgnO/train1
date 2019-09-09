package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.service.BookServoce;
import com.example.demo.service.impl.BooksServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
    private BooksServiceImpl booksService;

    @Autowired
    public BookController(@Qualifier("booksServiceImpl") BookServoce bookServoce, BooksServiceImpl booksService) {
        this.bookServoce = bookServoce;
        this.booksService = booksService;
    }

    @GetMapping("/all")
    public List<Book> selectAllBook() {
        return bookServoce.selectAllBook();
    }
}
