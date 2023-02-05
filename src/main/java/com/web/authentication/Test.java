package com.web.authentication;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class Test {
    public static void main(String[] args) {
        LocalDate currentDate = LocalDate.now();
        for (int i = 0; i < 7; i++) {
            LocalDate localDate = currentDate.plusDays(i);
            DayOfWeek dayOfWeek = localDate.getDayOfWeek();
            System.out.println(dayOfWeek.getDisplayName(TextStyle.FULL, Locale.ENGLISH));
        }
    }
}
