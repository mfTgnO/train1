package com.example.demo.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

/**
 * @package: com.example.demo.model
 * @author:
 * @email:
 * @createDate: 2019-08-01 11:53
 * @description: 省、直辖市、自治区
 */
@TableName("t_province")
@Data
public class Province implements Serializable {
    @Id
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String name;

    private String provinceId;
}
