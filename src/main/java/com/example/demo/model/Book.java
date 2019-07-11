package com.example.demo.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @package: com.example.demo.model
 * @author:
 * @email:
 * @createDate: 2019-05-23 17:48
 * @description:
 */
@Entity
@Table(name = "book")
public class Book implements Serializable {

    private static final long serialVersionUID = -1291504080631877186L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bookId;

    @Column(name = "book_name")
    private String bookName;

    @Column(name = "auther_name")
    private String autherName;

    @Column(name = "price")
    private int price;


    public String getAutherName() {
        return autherName;
    }

    public void setAutherName(String autherName) {
        this.autherName = autherName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }
}
