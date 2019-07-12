package com.example.demo.collections.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @package: com.example.demo.collections.domain
 * @author:
 * @email:
 * @createDate: 2019-07-12 14:14
 * @description:
 */
@Data
@AllArgsConstructor
public class TimePair {
    private long startTime;
    private long endTime;
}
