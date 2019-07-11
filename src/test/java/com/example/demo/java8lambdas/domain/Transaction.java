package com.example.demo.java8lambdas.domain;

import lombok.Data;

/**
 * @Package: com.example.demo.java8lambdas.model
 * @Author:
 * @Email:
 * @CreateDate: 2019-04-30 14:53
 * @Description:
 */
@Data
public class Transaction {
    private final Trader trader;
    private final int year;
    private final int value;
}
