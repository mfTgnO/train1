package com.example.demo.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @package: com.example.demo.model
 * @author:
 * @email:
 * @createDate: 2019-06-28 10:00
 * @description:
 */
@Data
@TableName("t_order")
public class OrderMQ implements Serializable {

    private static final long serialVersionUID = -629183058265905439L;
    @Id
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Long orderNumber;
    private Long productId;
    private BigDecimal amount;
}
