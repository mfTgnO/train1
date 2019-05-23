package com.example.demo.service.impl;

import com.example.demo.domain.Book;
import com.example.demo.mappers.BookMapper;
import com.example.demo.service.BookServoce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @package: com.example.demo.service.impl
 * @author:
 * @email:
 * @createDate: 2019-05-23 17:55
 * @description:
 */
@Service
public class BookServoceImpl implements BookServoce {
    private BookMapper bookMapper;

    @Autowired
    public BookServoceImpl(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    @Override
    public List<Book> selectAllBook() {
        return bookMapper.selectAllBook();
    }
}
