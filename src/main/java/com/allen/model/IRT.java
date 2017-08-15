package com.allen.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    public boolean isExpire() {
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String currentDate = dateFormat.format(new Date());

        IRT now = new IRT(currentDate);

        if (now.getYear() > year) {
            return false;
        }
        if (now.getYear() == year) {
            if (now.getDate() > date) {
                return false;
            }
            if (now.getDate() == date) {
                if (now.getHour() > hour) {
                    return false;
                }
                if (now.getHour() == hour) {
                    if (now.getMinute() > minute) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    // same day but is about expiring
    // pre-request: minutesLeft between 1 and 59
    public boolean isLessThan (int minutesLeft) {
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String currentDate = dateFormat.format(new Date());

        IRT now = new IRT(currentDate);

        if (now.getYear() == year && now.getDate() == date
                && now.getHour() == now.getHour()) {
            if (minute - now.getMinute() < minutesLeft) {
                return true;
            }
        }
        return false;
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
