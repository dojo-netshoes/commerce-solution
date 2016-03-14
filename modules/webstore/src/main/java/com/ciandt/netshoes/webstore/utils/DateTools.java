package com.ciandt.netshoes.webstore.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * Created by erickpr on 11/03/16.
 */
public class DateTools {

    public static Date localDateTimeToDate(final LocalDateTime localDateTime) {
        return java.sql.Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static Date localDateToDate(final LocalDate localDate) {
        final LocalTime localTime = LocalTime.MIN;
        final LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }
}
