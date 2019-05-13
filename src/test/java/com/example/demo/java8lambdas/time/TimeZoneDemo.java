package com.example.demo.java8lambdas.time;

import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * @Package: com.example.demo.java8lambdas.time
 * @Author:
 * @Email:
 * @CreateDate: 2019-05-13 13:38
 * @Description:
 */
public class TimeZoneDemo {
    @Test
    public void test1() {
//        TimeZone time = TimeZone.getTimeZone("GMT+8"); //设置为东八区
        TimeZone time = TimeZone.getDefault();// 这个是国际化所用的
        System.out.println(time);
        TimeZone.setDefault(time);// 设置时区
        Calendar calendar = Calendar.getInstance();// 获取实例
        DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");//构造格式化模板
        Date date = calendar.getTime(); //获取Date对象
        String str = new String();
        str = format1.format(date);//对象进行格式化，获取字符串格式的输出
        System.out.println(str);
    }

    @Test
    public void test2() {
        //假如这个是你已知的时间类型
        Calendar cal = Calendar.getInstance();
        cal.getTimeInMillis();
        //北京时区GMT+8
        Calendar beijingcal = Calendar.getInstance();
        beijingcal.clear();
        beijingcal.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        beijingcal.setTimeInMillis(cal.getTimeInMillis());
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String beijingFormatStr = fmt.format(beijingcal.getTime());
        System.out.println(beijingFormatStr);
    }

    /*
     * Migrating to the New Java 8 Date Time API
     * */
    @Test
    public void test3() {
        ZonedDateTime nextFriday = LocalDateTime.now()
                .plusHours(1)
                .with(TemporalAdjusters.next(DayOfWeek.FRIDAY))
                .atZone(ZoneId.of("CET"));
        System.out.println(nextFriday.toString());
    }

    @Test
    public void test4() {
        // old
        Date date = new Date();
        System.out.println(date.toString());

        // new
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println(now.toString());
    }

    @Test
    public void test5() {
        ZonedDateTime centralEastern = LocalDateTime.now().atZone(ZoneId.of("CET"));
        System.out.println(centralEastern.toString());
    }

    @Test
    public void test6() {
        ZonedDateTime centralEastern = LocalDateTime.now().atZone(ZoneId.of("UTC"));
        System.out.println(centralEastern.toString());

        LocalDateTime now = LocalDateTime.now();
        System.out.println(now.toString());
    }

    @Test
    public void test7() {
        ZonedDateTime centralEastern = LocalDateTime.now().atZone(ZoneId.of("CCT"));
        System.out.println(centralEastern.toString());
    }

    @Test
    public void test8() {
        ZoneId zoneId = ZoneId.systemDefault();
        System.out.println(zoneId.toString());
    }

    @Test
    public void test9() {
//        ZoneId australia = ZoneId.of("Australia/Sydney");
        ZoneId shanghai = ZoneId.of("Asia/Shanghai");
//        String str = "2015-01-05 17:00";
        String str = "2019-05-12 00:57:51";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localtDateAndTime = LocalDateTime.parse(str, formatter);
        ZonedDateTime dateAndTimeInSydney = ZonedDateTime.of(localtDateAndTime, shanghai);

        System.out.println("Current date and time in a Asia/Shanghai timezone : " + dateAndTimeInSydney);

        ZonedDateTime utcDate = dateAndTimeInSydney.withZoneSameInstant(ZoneOffset.UTC);

        System.out.println("Current date and time in UTC : " + utcDate);
    }

    @Test
    public void test10() {
        String str = "2019-05-12 00:57:51";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localtDateAndTime = LocalDateTime.parse(str, formatter);

        ZonedDateTime zonedDateTime = localtDateAndTime.atZone(ZoneOffset.UTC);
        System.out.println(zonedDateTime);
    }

    @Test
    public void test11() {
        Date date = new Date();
        System.out.println(date);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(date));
    }
}