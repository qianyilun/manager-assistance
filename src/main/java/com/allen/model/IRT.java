package com.allen.model;

import java.util.Calendar;

/**
 * Created by yilunq on 12/08/17.
 *
 * This class is to parse and analysis IRT
 *
 * @author Allen Qian
 */

public class IRT {
    private String irt;



    private Calendar irtCalendar;
    private int year;
    private int month;



    private int date;

    private int dayOfMonth;
    private int hour;
    private int minute;


    public IRT(String irt) {
        this.irt = irt;
        setVariables();
    }

    private void setVariables() {
        year = Integer.parseInt(irt.substring(0,4));

        date = Integer.parseInt(irt.substring(4,8));

        month = Integer.parseInt(irt.substring(4,6));
        dayOfMonth = Integer.parseInt(irt.substring(6,8));

        hour = Integer.parseInt(irt.substring(8,10));
        // match as PST hour
//        hour = hour - 7;

//        if (hour < 0) {
//            dayOfMonth -= 1;
//        }
//
//        if (dayOfMonth == 0) {
//            month -= 1;
//        }
//
//        if (month == 1) {
//            year -= 1;
//            month = 12;
//        }
        minute = Integer.parseInt(irt.substring(10,12));

        convertToCalendar();
    }


    private void convertToCalendar() {
        irtCalendar = Calendar.getInstance();

        irtCalendar.set(Calendar.YEAR, year);
        irtCalendar.set(Calendar.MONTH, month);
        irtCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        irtCalendar.set(Calendar.HOUR_OF_DAY, hour);
        irtCalendar.set(Calendar.MINUTE, minute);

        irtCalendar.add(Calendar.HOUR_OF_DAY, -7);


        int _year = irtCalendar.get(Calendar.YEAR);
        int _month = irtCalendar.get(Calendar.MONTH);
        int _dayOfMonth = irtCalendar.get(Calendar.DAY_OF_MONTH);
        int _hour = irtCalendar.get(Calendar.HOUR_OF_DAY);
        int _minute = irtCalendar.get(Calendar.MINUTE);
        int _second = irtCalendar.get(Calendar.SECOND);

        System.out.println("bcp time: " + "year = " + _year + ", month = " + _month + " , date = " + _dayOfMonth +" , hour = " + _hour
                + ", minutes = " + _minute + ", second = " + _second);
    }

    public Calendar getIrtCalendar() {
        return irtCalendar;
    }

//    public boolean isExpire() {
//        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
//        String currentDate = dateFormat.format(new Date());
//
//        IRT now = new IRT(currentDate);
//
//        if (now.getYear() > year) {
//            return false;
//        }
//        if (now.getYear() == year) {
//            if (now.getDate() > date) {
//                return false;
//            }
//            if (now.getDate() == date) {
//                // System's 19 hour = 12PST
//                if (now.getHour()+7 > hour) {
//                    return false;
//                }
//                if (now.getHour()+7 == hour) {
//                    if (now.getMinute() > minute) {
//                        return false;
//                    }
//                }
//            }
//        }
//        return true;
//    }

    // same day but is about expiring
    // pre-request: minutesLeft between 1 and 59
//    public boolean isLessThan (int minutesLeft) {
//        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
//        String currentDate = dateFormat.format(new Date());
//
//        IRT now = new IRT(currentDate);
//
//        if (now.getYear() == year && now.getDate() == date
//                && now.getHour() + 7 == hour) { // BCP's 19 hour = 12PST
//            if (minute - now.getMinute() <= minutesLeft) {
//                return true;
//            }
//        }
//        return false;
//    }


    public int getYear() {
        return year;
    }

    public int getDate() {
        return date;
    }


    public int getMonth() {
        return month;
    }

    public int getDayOfMonth() {
        return dayOfMonth;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    @Override
    public String toString() {
        return "[Class IRT = "+"Year = "+year+", Month = "+month+", Day of month = "+dayOfMonth+", Hour = "+(hour)+", Minute = "+minute+"]";
    }
}
