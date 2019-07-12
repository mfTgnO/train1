package com.example.demo.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
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
@TableName("t_user")
public class UserTestData implements Serializable {
    /*@Id
    @GeneratedValue(strategy = GenerationType.AUTO)*/
    @Id
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String userId;

    private String name;

    private Integer provinceId;

    private Integer cityId;

    private LocalDateTime createTime;
}
