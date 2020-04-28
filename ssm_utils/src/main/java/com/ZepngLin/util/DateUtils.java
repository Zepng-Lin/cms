package com.ZepngLin.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static Date strToDate(String str) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return dateFormat.parse(str);
    }
    public static String dateToStr(Date date) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return dateFormat.format(date);
    }
}
