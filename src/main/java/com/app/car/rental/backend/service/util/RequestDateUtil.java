package com.app.car.rental.backend.service.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RequestDateUtil {
    public static String addTimeToDate(String date) {
        if (date != null) {
            LocalDateTime localDateTime = LocalDate.parse(date, DateTimeFormatter.ISO_DATE).atStartOfDay();
            // NOTE: plusHours 12 - to avoid
            // {"code":"242","message":"Bad Request","reason":"The Rental Location you have selected is closed during the hours requested"}
            return localDateTime.plusHours(12).format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"));
        }

        return null;
    }
}
