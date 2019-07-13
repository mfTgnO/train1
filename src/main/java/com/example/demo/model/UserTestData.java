package com.example.demo.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
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
    @Id
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")
    private Integer id;

    @TableField(value = "c_user_id")
    private String userId;

    @TableField(value = "c_name")
    private String name;

    @TableField(value = "c_province_id")
    private Integer provinceId;

    @TableField(value = "c_city_id")
    private Integer cityId;

    @TableField(value = "create_time")
    private LocalDateTime createTime;
}
