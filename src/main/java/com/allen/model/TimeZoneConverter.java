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

    public void convert(String year, String month, String dayOfMonth,
                        String hour, String minute) {
        // convert a String to Calendar
//        Calendar bcpSystemCalendar = Calendar.getInstance();
//        bcpSystemCalendar.set(Calendar.YEAR, new Integer(year));
//        bcpSystemCalendar.set(Calendar.MONTH, new Integer(month));
//        bcpSystemCalendar.set(Calendar.DAY_OF_MONTH, new Integer(dayOfMonth));
//        bcpSystemCalendar.set(Calendar.HOUR, new Integer(hour));
//        bcpSystemCalendar.set(Calendar.MINUTE, new Integer(minute));







        String bcpTime = "20170825250048";
//
        String pattern = "yyyyMMddHHmmss";
        Date date = null;
        try {
            date = new SimpleDateFormat(pattern).parse(bcpTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar bcpSystemCalendar = Calendar.getInstance();
        bcpSystemCalendar.setTime(date);

        int _year = bcpSystemCalendar.get(Calendar.YEAR);
        int _month = bcpSystemCalendar.get(Calendar.MONTH);
        int _dayOfMonth = bcpSystemCalendar.get(Calendar.DAY_OF_MONTH);
        int _hour = bcpSystemCalendar.get(Calendar.HOUR);
        int _minute = bcpSystemCalendar.get(Calendar.MINUTE);
        int _second = bcpSystemCalendar.get(Calendar.SECOND);

        System.out.println("bcp time: " + "year = " + _year + ", month = " + _month + " , date = " + _dayOfMonth +" , hour = " + _hour
                + ", minutes = " + _minute + ", second = " + _second);


//        // convert bcp Calendar to local Calendar
//        bcpLocalCalendar = new GregorianCalendar(Calendar.getInstance().getTimeZone());
//        bcpLocalCalendar.setTimeInMillis(bcpSystemCalendar.getTimeInMillis());



    }

    @Override
    public String toString() {
        int year = bcpLocalCalendar.get(Calendar.YEAR);
        int month = bcpLocalCalendar.get(Calendar.MONTH);
        int dayOfMonth = bcpLocalCalendar.get(Calendar.DAY_OF_MONTH);
        int hour = bcpLocalCalendar.get(Calendar.HOUR);
        int minute = bcpLocalCalendar.get(Calendar.MINUTE);
        int second = bcpLocalCalendar.get(Calendar.SECOND);

        return "bcp to local time: " + "year = " + year + ", month = " + month + " , date = " + dayOfMonth +" , hour = " + hour
                + ", minutes = " + minute + ", second = " + second;
    }
}
