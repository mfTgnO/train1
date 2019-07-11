package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @package: com.example.demo.model
 * @author:
 * @email:
 * @createDate: 2019-06-13 13:46
 * @description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_user")
//@TableName("t_user")
public class UserTestData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Id
//    @TableId(type = IdType.AUTO)
    private Integer id;

    private String userId;

    private String name;

    private Integer provinceId;

    private Integer cityId;

    private LocalDateTime createTime;
}
