package com.example.demo.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

/**
 * @package: com.example.demo.model
 * @author:
 * @email:
 * @createDate: 2019-07-30 16:13
 * @description: 区、县
 */
@TableName("t_country")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Country {
    @Id
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String name;

    private String countryId;

    private String cityId;
}
