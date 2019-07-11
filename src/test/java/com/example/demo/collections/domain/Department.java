package com.example.demo.collections.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Package: com.example.demo.collections.model
 * @Author:
 * @Email:
 * @CreateDate: 2019-04-26 18:49
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department implements Serializable {

    private static final long serialVersionUID = 5383936653900408263L;
    Integer id;
    String name;
}
