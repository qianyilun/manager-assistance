package com.allen.model;

/*
 * This class is to convert the local time to BCP's time
 *
 * @author Allen Qian
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeZoneConverter {
    private Calendar calendar = Calendar.getInstance();

    public Calendar getCalendar() {
        return calendar;
    }

    public void convert(String bcpTime) {
        // convert a String to Calendar
        String pattern = "yyyyMMddHHmmss";
        Date date = null;
        try {
            date = new SimpleDateFormat(pattern).parse(bcpTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        calendar.setTime(date);

        // convert local Calendar to bcp Calendar
    }
}
