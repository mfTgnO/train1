package com.example.demo.foundation;

import com.example.demo.collections.domain.TimePair;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

import java.util.Calendar;
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

    /**
     * 以毫秒为单位返回当前时间。
     */
    @Test
    public void test2() {
        long currentTimeMillis = System.currentTimeMillis();
        System.out.println(currentTimeMillis);

        currentTimeMillis = 1553658737149L;
        // 将毫秒时间转换为：Thu Jul 11 15:35:11 GMT+08:00 2019
        Date date = new Date(currentTimeMillis);
        System.out.println(date);
    }

    /**
     * 获取这个月的时间戳范围
     */
    @Test
    public void test3() {
        TimePair monthTimeRange = getMonthTimeRange();

        // TimePair(startTime=1561910400000, endTime=1564588800000)
        System.out.println(monthTimeRange);

        // Mon Jul 01 00:00:00 GMT+08:00 2019
        System.out.println(new Date(monthTimeRange.getStartTime()));

        // Thu Aug 01 00:00:00 GMT+08:00 2019
        System.out.println(new Date(monthTimeRange.getEndTime()));
    }

    public TimePair getMonthTimeRange() {
        Calendar c = Calendar.getInstance();

        c.set(Calendar.DAY_OF_MONTH, 1);//本月第一天
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        long startTime = c.getTime().getTime();

        c = Calendar.getInstance();
        c.add(Calendar.MONTH, 1);//本月最后一天
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        c.set(Calendar.DAY_OF_MONTH, 1);

        long endTime = c.getTime().getTime();
        return new TimePair(startTime, endTime);
    }

    @Test
    public void test4() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        long dateTime = calendar.getTimeInMillis();
        System.out.println(dateTime);
    }
}