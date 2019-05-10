package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Package: com.example.demo.domain
 * @Author:
 * @Email:
 * @CreateDate: 2019-05-10 17:29
 * @Description:
 */
@Data
@AllArgsConstructor
public class User {
    private Integer id;
    private String name;
    private String email;
}
