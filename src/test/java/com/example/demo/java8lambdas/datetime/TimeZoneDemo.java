package com.example.demo.java8lambdas.datetime;

import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.chrono.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import static java.time.temporal.TemporalAdjusters.lastDayOfMonth;
import static java.time.temporal.TemporalAdjusters.nextOrSame;

/**
 * @Package: com.example.demo.java8lambdas.datetime
 * @Author:
 * @Email:
 * @CreateDate: 2019-05-13 13:38
 * @Description:
 */
public class TimeZoneDemo {
    @Test
    public void test1() {
//        TimeZone datetime = TimeZone.getTimeZone("GMT+8"); //设置为东八区
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

        System.out.println("Current date and datetime in a Asia/Shanghai timezone : " + dateAndTimeInSydney);

        ZonedDateTime utcDate = dateAndTimeInSydney.withZoneSameInstant(ZoneOffset.UTC);

        System.out.println("Current date and datetime in UTC : " + utcDate);
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

    /*
     * In Java 1.0 the only support for date and time was the java.util.Date class. Despite its name, this
     * class doesn’t represent a date but a point in time with milliseconds precision. Even worse, the
     * usability of this class is harmed by some nebulous design decisions like the choice of its offsets:
     * the years start from 1900, whereas the months start at index 0. This means that if you want to
     * represent the release date of Java 8, which is March 18, 2014, you have to create an instance of
     * Date as follows:
     * */
    @Test
    public void test12() {
        Date date = new Date(114, 2, 18);
        System.out.println(date);
    }

    /*
     * 12.1. LocalDate, LocalTime, Instant, Duration, and Period
     *
     * 12.1.1. Working with LocalDate and LocalTime
     * An instance of this class is an immutable object representing just a plain date without the time of day.
     * You can create a LocalDate instance using the of static factory method.
     *
     * Listing 12.1. Creating a LocalDate and reading its values
     * */
    @Test
    public void test13() {
        // 2014-03-18
        LocalDate date = LocalDate.of(2014, 3, 18);
        // 2014
        int year = date.getYear();
        // MARCH
        Month month = date.getMonth();
        // 18
        int dayOfMonth = date.getDayOfMonth();
        // TUESDAY
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        // 31 (days in March)
        int len = date.lengthOfMonth();
        //
        int lengthOfYear = date.lengthOfYear();
        // false (not a leap year)
        boolean leapYear = date.isLeapYear();

        System.out.println("date:" + date);
        System.out.println("year:" + year);
        System.out.println("month:" + month);
        System.out.println("dayOfMonth:" + dayOfMonth);
        System.out.println("lengthOfYear:" + lengthOfYear);
        System.out.println("dayOfWeek:" + dayOfWeek);
        System.out.println("len:" + len);
        System.out.println("leapYear:" + leapYear);
    }

    /*
     * It’s also possible to obtains the current date from the system clock using the now factory method:
     * */
    @Test
    public void test14() {
        LocalDate now = LocalDate.now();
        System.out.println(now);
    }

    /*
     * Listing 12.2. Reading LocalDate values using a TemporalField
     * */
    @Test
    public void test15() {
        LocalDate now = LocalDate.now();
        int year = now.get(ChronoField.YEAR);
        int month = now.get(ChronoField.MONTH_OF_YEAR);
        int day = now.get(ChronoField.DAY_OF_MONTH);
        System.out.println("year:" + year);
        System.out.println("month:" + month);
        System.out.println("day:" + day);
    }

    /*
     * Listing 12.3. Creating a LocalTime and reading its values
     * */
    @Test
    public void test16() {
        // 13:45:20
        LocalTime time = LocalTime.of(13, 45, 20);
        int hour = time.getHour();
        int minute = time.getMinute();
        int second = time.getSecond();
        System.out.println("hour:" + hour);
        System.out.println("minute:" + minute);
        System.out.println("second:" + second);
    }

    /*
     * Both LocalDate and LocalTime can be created by parsing a String representing them. You can
     * achieve this using their parse static methods:
     * */
    @Test
    public void test17() {
        LocalDate date = LocalDate.parse("2014-03-18");
        LocalTime time = LocalTime.parse("13:45:20");
        System.out.println(date);
        System.out.println(time);
    }

    /*
     * 12.1.2. Combining a date and a time
     * The composite class called LocalDateTime pairs a LocalDate and a LocalTime. It represents both
     * a date and a time, without a time zone, and can be created either directly or by combining a date
     * and time, as shown in the next listing.
     * */
    @Test
    public void test18() {
        LocalDate date = LocalDate.parse("2014-03-18");
        LocalTime time = LocalTime.parse("13:45:20");

        // 2014-03-18T13:45:20
        LocalDateTime dt1 = LocalDateTime.of(2014, Month.MARCH, 18, 13, 45, 20);
        LocalDateTime dt2 = LocalDateTime.of(date, time);
        LocalDateTime dt3 = date.atTime(23, 45, 20);
        LocalDateTime dt4 = date.atTime(time);
        LocalDateTime dt5 = time.atDate(date);

        LocalDate date1 = dt1.toLocalDate();
        LocalTime time1 = dt1.toLocalTime();

        System.out.println(dt1);
        System.out.println(dt2);
        System.out.println(dt3);
        System.out.println(dt4);
        System.out.println(dt5);
        System.out.println(date1);
        System.out.println(time1);
    }

    /*
     * 12.1.3. Instant: a date and time for machines
     *
     * You can create an instance of this class by passing the number of seconds to its ofEpochSecond
     * static factory method. In addition, the Instant class supports nanosecond precision. There’s a
     * supplementary overloaded version of the ofEpochSecond static factory method that accepts a
     * second argument that’s a nanosecond adjustment to the passed number of seconds. This
     * overloaded version adjusts the nanosecond argument, ensuring that the stored nanosecond
     * fraction is between 0 and 999,999,999. This means all the following invocations of the
     * ofEpochSecond factory method will return exactly the same Instant:
     * */
    @Test
    public void test19() {
        Instant instant1 = Instant.ofEpochSecond(3);
        Instant instant2 = Instant.ofEpochSecond(3, 0);
        Instant instant3 = Instant.ofEpochSecond(2, 1_000_000_000);
        Instant instant4 = Instant.ofEpochSecond(4, -1_000_000_000);

        System.out.println(instant1);
        System.out.println(instant2);
        System.out.println(instant3);
        System.out.println(instant4);
    }

    @Test
    public void test20() {
        Instant now = Instant.now();

        /*
         * will just throw an exception like
         * java.time.temporal.UnsupportedTemporalTypeException: Unsupported field: DayOfMonth
         * */
        int dayOfMonth = now.get(ChronoField.DAY_OF_MONTH);
        int dayOfWeek = now.get(ChronoField.DAY_OF_WEEK);
        int dayOfYear = now.get(ChronoField.DAY_OF_YEAR);

        System.out.println(now);
        System.out.println(dayOfMonth);
        System.out.println(dayOfWeek);
        System.out.println(dayOfYear);
    }

    /*
     * 12.1.4. Defining a Duration or a Period
     * */
    @Test
    public void test21() {
        LocalTime time1 = LocalTime.of(1, 1, 1);
        LocalTime time2 = LocalTime.of(1, 1, 2);
        LocalDateTime dateTime1 = LocalDateTime.of(2019, 1, 1, 1, 1, 1);
        LocalDateTime dateTime2 = LocalDateTime.of(2019, 2, 1, 1, 1, 1);
        Instant instant1 = Instant.ofEpochSecond(3);
        Instant instant2 = Instant.now();

        Duration d1 = Duration.between(time1, time2);
        Duration d2 = Duration.between(dateTime1, dateTime2);
        Duration d3 = Duration.between(instant1, instant2);

        System.out.println(d1);
        System.out.println(d2);
        System.out.println(d3);

        /*
         * When you need to model an amount of time in terms of years, months, and days, you can use
         * the Period class. You can find out the difference between two LocalDates with the between
         * factory method of that class:
         * */
        Period tenDays = Period.between(LocalDate.of(2014, 3, 8),
                LocalDate.of(2014, 3, 18));
        System.out.println(tenDays);
        System.out.println("====================================================================");

        Duration threeMinustes1 = Duration.ofMinutes(3);
        Duration threeMinustes2 = Duration.of(3, ChronoUnit.MINUTES);
        Period tenDays2 = Period.ofDays(10);
        Period threeWeeks = Period.ofWeeks(3);
        Period twoYearsSixMonthsOneDay = Period.of(2, 6, 1);

        System.out.println(threeMinustes1);
        System.out.println(threeMinustes2);
        System.out.println(tenDays2);
        System.out.println(threeWeeks);
        System.out.println(twoYearsSixMonthsOneDay);
    }

    /*
     * 12.2. Manipulating, parsing, and formatting dates
     * */
    @Test
    public void test22() {
        LocalDate date = LocalDate.of(2014, 3, 18);
        LocalDate date1 = date.withYear(2011);
        LocalDate date2 = date.withDayOfMonth(25);
        LocalDate date3 = date.with(ChronoField.MONTH_OF_YEAR, 9);

        System.out.println(date);
        System.out.println(date1);
        System.out.println(date2);
        System.out.println(date3);
    }

    /*
     * Listing 12.7. Manipulating the attributes of a LocalDate in a relative way
     * */
    @Test
    public void test23() {
        LocalDate date = LocalDate.of(2014, 3, 18);
        LocalDate date1 = date.plusWeeks(1);
        LocalDate date2 = date.minusYears(3);
        LocalDate date3 = date.plus(6, ChronoUnit.MONTHS);

        System.out.println(date);
        System.out.println(date1);
        System.out.println(date2);
        System.out.println(date3);
    }

    @Test
    public void test24() {
        LocalDate date = LocalDate.of(2014, 3, 18);
        System.out.println(date);

        date = date.with(ChronoField.MONTH_OF_YEAR, 9);
        System.out.println(date);

        date = date.plusYears(2).minusDays(10);
        System.out.println(date);

        LocalDate date1 = date.withYear(2011);
        System.out.println(date1);

    }

    /*
     * 12.2.1. Working with TemporalAdjusters
     * */
    @Test
    public void test25() {
        LocalDate date = LocalDate.of(2014, 3, 18);
        LocalDate date1 = date.with(nextOrSame(DayOfWeek.SUNDAY));
        LocalDate date2 = date.with(lastDayOfMonth());

        System.out.println(date);
        System.out.println(date1);
        System.out.println(date2);
    }

    /*
     * 12.2.2. Printing and parsing date-time objects
     * */
    @Test
    public void test26() {
        LocalDate date = LocalDate.of(2014, 3, 18);

        // 20140318
        String date1 = date.format(DateTimeFormatter.BASIC_ISO_DATE);
        // 2014-03-18
        String date2 = date.format(DateTimeFormatter.ISO_LOCAL_DATE);

        LocalDate date3 = LocalDate.parse("20140318", DateTimeFormatter.BASIC_ISO_DATE);
        LocalDate date4 = LocalDate.parse("2014-03-18", DateTimeFormatter.ISO_LOCAL_DATE);

        System.out.println(date1);
        System.out.println(date2);
        System.out.println(date3);
        System.out.println(date4);
    }

    /*
     * Listing 12.10. Creating a DateTimeFormatter from a pattern
     * */
    @Test
    public void test27() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.of(2014, 3, 18);

        String formattedDate = date.format(formatter);
        LocalDate date1 = LocalDate.parse(formattedDate, formatter);

        System.out.println(formattedDate);
        System.out.println(date1);
    }

    /*
     * Listing 12.11. Creating a localized DateTimeFormatter
     * */
    @Test
    public void test28() {
        DateTimeFormatter italianFormatter = DateTimeFormatter.ofPattern("d. MMMM yyyy", Locale.ITALIAN);
        LocalDate date = LocalDate.of(2014, 3, 18);

        String formattedDate = date.format(italianFormatter);
        LocalDate date1 = LocalDate.parse(formattedDate, italianFormatter);

        System.out.println(formattedDate);
        System.out.println(date1);
    }

    /*
     * Listing 12.12. Building a DateTimeFormatter
     * */
    @Test
    public void test29() {
        LocalDate date = LocalDate.of(2014, 3, 18);

        DateTimeFormatter italianFormatter = new DateTimeFormatterBuilder()
                .appendText(ChronoField.DAY_OF_MONTH)
                .appendLiteral(". ")
                .appendText(ChronoField.MONTH_OF_YEAR)
                .appendLiteral(" ")
                .appendText(ChronoField.YEAR)
                .parseCaseInsensitive()
                .toFormatter(Locale.ITALIAN);
        String format = date.format(italianFormatter);
        System.out.println(format);
    }

    /*
     * 12.3. Working with different time zones and calendars
     *
     * A time zone is a set of rules corresponding to a region in which the standard time is the same.
     * There are about 40 of them held in instances of the ZoneRules class. You can simply call
     * getRules() on a ZoneId to obtain the rules for that given time zone. A specific ZoneId is
     * identified by a region ID, for example:
     * */
    @Test
    public void test30() {
        ZoneId romeZone = ZoneId.of("Europe/Rome");
        System.out.println(romeZone);

        /*
         * The region IDs are all in the format “{area}/{city}” and the set of available locations is the one
         * supplied by the IANA Time Zone Database. You can also convert an old TimeZone object to a
         * ZoneId by using the new method toZoneId:
         * */
        ZoneId zoneId = TimeZone.getDefault().toZoneId();
        System.out.println(zoneId);

        /*
         * Once you have a ZoneId object, you can combine it with a LocalDate, a LocalDateTime, or an
         * Instant, to transform it into ZonedDateTime instances, which represent points in time relative
         * to the specified time zone, as shown in the next listing.
         * */
    }

    /*
     * Listing 12.13. Applying a time zone to a point in time
     * */
    @Test
    public void test31() {
        ZoneId romeZone = ZoneId.of("Europe/Rome");
        LocalDate date = LocalDate.of(2014, Month.MARCH, 18);
        ZonedDateTime zdt1 = date.atStartOfDay(romeZone);

        LocalDateTime dateTime = LocalDateTime.of(2014, Month.MARCH, 18, 18, 13, 45);
        ZonedDateTime zdt2 = dateTime.atZone(romeZone);

        Instant instant = Instant.now();
        ZonedDateTime zdt3 = instant.atZone(romeZone);

        System.out.println(zdt1);
        System.out.println(zdt2);
        System.out.println(zdt3);

        /*
         * You can also convert a LocalDateTime to an Instant by using a ZoneId:
         * */
        Instant instantFromDateTime = dateTime.toInstant((ZoneOffset) romeZone);
        System.out.println("instantFromDateTime:" + instantFromDateTime);

        /*
         * Or you can do it the other way around:
         * */
        LocalDateTime timeFromInstant = LocalDateTime.ofInstant(instant, romeZone);
        System.out.println("timeFromInstant :" + timeFromInstant);
    }

    /*
     * 12.3.1. Fixed offset from UTC/Greenwich
     *
     * Another common way to express a time zone is with a fixed offset from UTC/Greenwich. For
     * instance, you can use this notation to say that “New York is five hours behind London.” In cases
     * like this you can use the ZoneOffset class, a subclass of ZoneId that represents the difference
     * between a time and the zero meridian of Greenwich, London:
     * */
    @Test
    public void test32() {
        ZoneOffset newYorkOffset = ZoneOffset.of("-05:00");
        String id = newYorkOffset.getId();
        LocalDateTime dateTime = LocalDateTime.of(2014, Month.MARCH, 18, 18, 13, 45);
        OffsetDateTime dateTimeInNewYork = OffsetDateTime.of(dateTime, newYorkOffset);

        System.out.println(id);
        System.out.println(newYorkOffset);
        System.out.println(dateTime);
        System.out.println(dateTimeInNewYork);
    }

    /*
     * 12.3.2. Using alternative calendar systems
     * */
    @Test
    public void test33() {
        LocalDate date = LocalDate.of(2014, Month.MARCH, 18);
        JapaneseDate japaneseDate = JapaneseDate.from(date);
        System.out.println(japaneseDate);
    }

    /*
     * Alternatively, you can explicitly create a calendar system for a specific Locale and create an
     * instance of a date for that Locale. In the new Date and Time API, the Chronology interface
     * models a calendar system, and you can obtain an instance of it using its ofLocale static factory
     * method:
     * */
    @Test
    public void test34() {
        Chronology japaneseChronology = Chronology.ofLocale(Locale.JAPAN);
        ChronoLocalDate chronoLocalDate = japaneseChronology.dateNow();
        System.out.println(chronoLocalDate);
    }

    /*
     * Islamic calendar
     * */
    @Test
    public void test35() {
        HijrahDate ramadanDate = HijrahDate.now().with(ChronoField.DAY_OF_MONTH, 1)
                // Get current Hijrah date;then change it to have the first day of Ramadan,which is the 9th month.
                .with(ChronoField.MONTH_OF_YEAR, 9);
        System.out.println("Ramadan starts on " +
                IsoChronology.INSTANCE.date(ramadanDate) +
                " and ends on " +
                IsoChronology.INSTANCE.date(ramadanDate.with(TemporalAdjusters.lastDayOfMonth())));
    }
}