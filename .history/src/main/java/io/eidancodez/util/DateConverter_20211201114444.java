package io.eidancodez.util;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DateConverter {

    public static Map<String, String> gerrentWeek() {
        Map<String, String> currentWeek = new HashMap<>();
        LocalDate today = LocalDate.now();

        // Go backward to get Monday
        LocalDate monday = today;
        while (monday.getDayOfWeek() != DayOfWeek.MONDAY) {
            monday = monday.minusDays(1);
        }

        // Go forward to get Sunday
        LocalDate sunday = today;
        while (sunday.getDayOfWeek() != DayOfWeek.SUNDAY) {
            sunday = sunday.plusDays(1);
        }

        currentWeek.put("today", today.toString());
        currentWeek.put("mondayOfTheWeek", monday.toString());
        currentWeek.put("sundayOfTheWeek", sunday.toString());

        return currentWeek;
    }
}
