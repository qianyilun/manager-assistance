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
        minute = Integer.parseInt(irt.substring(10,12));
    }

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
