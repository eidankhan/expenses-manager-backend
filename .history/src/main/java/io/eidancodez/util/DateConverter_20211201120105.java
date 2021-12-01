package io.eidancodez.util;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class DateConverter {

    public static Map<String, LocalDate> gerrentWeek() {
        Map<String, LocalDate> currentWeek = new HashMap<>();
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

        currentWeek.put("today", today);
        currentWeek.put("mondayOfTheWeek", monday);
        currentWeek.put("sundayOfTheWeek", sunday);

        return currentWeek;
    }
}
