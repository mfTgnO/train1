package com.example.demo.mappers;

import com.example.demo.domain.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @package: com.example.demo.mappers
 * @author:
 * @email:
 * @createDate: 2019-05-23 17:52
 * @description:
 */
@Repository
public interface BookMapper {
    List<Book> selectAllBook();
}
