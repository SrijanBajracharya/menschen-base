package com.achiever.menschenfahren.base.helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Nonnull;

public class DateHelper {

    public static String convertDate(@Nonnull final Date date) {
        final String pattern = "yyyy-MM-dd";
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        final String dateString = simpleDateFormat.format(date);
        return dateString;
    }

    public static Date stringToDateConverter(@Nonnull final String dateString) throws ParseException {
        Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
        System.err.println(date1);
        return date1;
    }

}
