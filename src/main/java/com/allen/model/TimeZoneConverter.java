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
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class TimeZoneConverter {
    private Calendar bcpLocalCalendar = Calendar.getInstance();

    public Calendar getCalendar() {
        return bcpLocalCalendar;
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
        Calendar bcpSystemCalendar = Calendar.getInstance();
        bcpSystemCalendar.setTime(date);

        

        // convert bcp Calendar to local Calendar
        bcpLocalCalendar = new GregorianCalendar(Calendar.getInstance().getTimeZone());
        bcpLocalCalendar.setTimeInMillis(bcpSystemCalendar.getTimeInMillis());
        System.out.println(this);
    }

    @Override
    public String toString() {
        int year = bcpLocalCalendar.get(Calendar.YEAR);
        int month = bcpLocalCalendar.get(Calendar.MONTH);
        int date = bcpLocalCalendar.get(Calendar.DAY_OF_MONTH);
        int hour = bcpLocalCalendar.get(Calendar.HOUR);
        int minute = bcpLocalCalendar.get(Calendar.MINUTE);
        int second = bcpLocalCalendar.get(Calendar.SECOND);

        return "bcp to local time: " + "year = " + year + ", month = " + month + " , date = " + date +" , hour = " + hour
                + ", minutes = " + minute + ", second = " + second;
    }
}
