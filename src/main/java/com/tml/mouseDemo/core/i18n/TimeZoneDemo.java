package com.tml.mouseDemo.core.i18n;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class TimeZoneDemo {
    public static void main(String[] args) {
        TimeZone tz = TimeZone.getDefault();
        System.out.println(tz.getID());

        Locale locale = Locale.getDefault();

        Date date = new Date();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        df.setTimeZone(tz);
        System.out.println(df.format(date));


    }
}
