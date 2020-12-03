package com.hivecloud.reading.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.hivecloud.reading.constants.CommonConstants.DATE_PATTERN;

public class DateUtils {

    static DateTimeFormatter fmt = DateTimeFormatter.ofPattern(DATE_PATTERN);

    public static LocalDate parseDate(String stringDateFormatted) {
        return LocalDate.parse(stringDateFormatted, fmt);
    }
}
