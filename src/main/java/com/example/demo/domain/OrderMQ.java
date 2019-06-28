package com.example.demo.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @package: com.example.demo.domain
 * @author:
 * @email:
 * @createDate: 2019-06-28 10:00
 * @description:
 */
@Data
public class OrderMQ implements Serializable {

    private static final long serialVersionUID = -629183058265905439L;

    private String orderNumber;
    private String productId;
    private double amount;
}
