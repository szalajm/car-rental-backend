package com.app.car.rental.backend.service.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RequestDateUtilTest {

    @Test
    void addTimeToDate() {
        // given
        String date = "2020-09-09";
        // when
        String dateTime = RequestDateUtil.addTimeToDate(date);
        System.out.println(dateTime);
        // then
        assertNotNull(dateTime, "Date with added Time is null");
    }
}