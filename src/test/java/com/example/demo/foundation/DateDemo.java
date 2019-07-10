package com.example.demo.foundation;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

import java.util.Date;

/**
 * @package: com.example.demo.foundation
 * @author:
 * @email:
 * @createDate: 2019-07-10 10:43
 * @description:
 */
public class DateDemo {
    @Test
    public void test1() {
        Date date = new Date();
        // Wed Jul 10 10:47:38 GMT+08:00 2019
        System.out.println(date);

        // 以当前日期为准，往后10天
        date = DateUtils.addDays(date, -15);
        // Tue Jun 25 10:47:38 GMT+08:00 2019
        System.out.println(date);

        // // 以当前日期为准，往前25天
        date = DateUtils.addDays(date, 25);
        // Sat Jul 20 10:47:38 GMT+08:00 2019
        System.out.println(date);
    }
}
