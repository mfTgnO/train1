package com.example.demo.service.impl;

import com.example.demo.model.Book;
import com.example.demo.service.BookServoce;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksServiceImpl implements BookServoce {
    @Override
    public List<Book> selectAllBook() {
        return null;
    }
}
