package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.function.Supplier;

/**
 * @Package: com.example.demo.domain
 * @Author:
 * @Email:
 * @CreateDate: 2019-05-10 17:29
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User implements Serializable{

    private static final long serialVersionUID = 8548297306458565309L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private String email;
}
