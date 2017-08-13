package com.allen.model;

/**
 * Created by yilunq on 12/08/17.
 *
 * This class is to parse and analysis IRT
 */

public class IRT {
    private String irt;
    private int year;
    private int date;
    private int hour;
    private int minute;


    public IRT(String irt) {
        this.irt = irt;
        setVaraibles();
    }

    private void setVaraibles() {
        year = Integer.parseInt(irt.substring(0,4));
        date = Integer.parseInt(irt.substring(4,8));
        hour = Integer.parseInt(irt.substring(8,10));
        minute = Integer.parseInt(irt.substring(10,12));
    }

    public int getYear() {
        return year;
    }

    public int getDate() {
        return date;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    @Override
    public String toString() {
        return "[Class IRT = "+"Year = "+year+", Date = "+date+", Hour = "+hour+", Minute = "+minute+"]";
    }
}
