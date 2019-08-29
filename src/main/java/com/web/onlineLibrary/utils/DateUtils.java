package com.web.onlineLibrary.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static Date toDate(String str) throws ParseException {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date=format.parse(str);
        return date;
    }
}
