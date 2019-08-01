package com.example.demo.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 * @package: com.example.demo.model
 * @author:
 * @email:
 * @createDate: 2019-08-01 15:05
 * @description: 街道、镇
 */
@TableName("t_town")
@Data
public class Town {
    @Id
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String townId;

    private String countryId;
}
