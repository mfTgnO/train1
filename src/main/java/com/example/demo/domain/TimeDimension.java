package com.example.demo.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * @Package: com.example.demo.domain
 * @Author:
 * @Email:
 * @CreateDate: 2019-05-23 13:22
 * @Description:
 */
@Data
/*@Entity
@Table(name = "time_dimension")*/
public class TimeDimension implements Serializable {

    private static final long serialVersionUID = 75620193939321498L;

    /*@Id
    @GeneratedValue(strategy = GenerationType.AUTO)*/
    private Integer id;

    private LocalDate dbDate;

    private Integer year;

    private Integer month;

    private Integer day;

    private Integer quarter;

    private Integer week;

    private String dayName;

    private String monthName;

    private String holidayFlag;

    private String weekendFlag;

    private String event;
}
