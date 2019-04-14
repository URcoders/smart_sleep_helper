package com.linxu.pillow.utils;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author linxu
 * @version 1.0
 * date time tool...
 */
public class DateUtil {
    private static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";
    private static final String SIMPLE_DATE_PATTERN = "yyyy-MM-dd";

    public static String getCurrentTime() {
        SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_DATE_PATTERN);
        return sdf.format(System.currentTimeMillis());
    }

    public static String addDay(String time) {
        Format f = new SimpleDateFormat(SIMPLE_DATE_PATTERN);

        Calendar c = Calendar.getInstance();
        try {
            c.setTime(((SimpleDateFormat) f).parse(time));
        } catch (ParseException e) {
            try {
                c.setTime(((SimpleDateFormat) f).parse(time.trim()));
            } catch (ParseException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
        c.add(Calendar.DAY_OF_MONTH, 1);
        return f.format(c.getTime());
    }

}
