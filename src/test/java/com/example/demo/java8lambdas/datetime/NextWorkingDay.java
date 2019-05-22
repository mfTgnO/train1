package com.example.demo.java8lambdas.datetime;

import java.time.DayOfWeek;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;

/**
 * @Package: com.example.demo.java8lambdas.datetime
 * @Author:
 * @Email:
 * @CreateDate: 2019-05-22 16:40
 * @Description:
 */
public class NextWorkingDay implements TemporalAdjuster {
    @Override
    public Temporal adjustInto(Temporal temporal) {
        // Read the current day.
        DayOfWeek dow = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));
        // Normally add one day.
        int dayToAdd = 1;
        if (dow == DayOfWeek.FRIDAY) {
            // But add three days if today is a Friday.
            dayToAdd = 3;
        } else if (dow == DayOfWeek.SATURDAY) {
            // Or two if it's a Saturday.
            dayToAdd = 2;
        }
        // Return the modified date adding the right number of days.
        return temporal.plus(dayToAdd, ChronoUnit.DAYS);
    }
}
