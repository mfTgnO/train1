package com.example.demo.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

/**
 * @package: com.example.demo.model
 * @author:
 * @email:
 * @createDate: 2019-07-12 15:56
 * @description:
 */
@TableName("t_rank")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Rank implements Serializable {
    @Id
    @TableId(type = IdType.AUTO)
    private Integer pid;
    private String name;
    private Integer age;
    private Integer groupid;
}
