package com.example.gtaches;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static java.lang.Math.abs;

public class dateMe {

    public static enum Type{
        minute,heure,jour
    }

    public static long dayBetween(String day1,String day2,Type type) {
        SimpleDateFormat myFormat = new SimpleDateFormat("yy-MM-dd");
        long dayBetween = 0;
        try {
            Date date1 = myFormat.parse(day1);//convert string into date
            Date date2 = myFormat.parse(day2);
            long diff = date1.getTime()-date2.getTime() ;//calcul difirence between dates in milisecond
            switch (type)
            {
                case jour:
                    dayBetween = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
                    break;
                case heure:
                    dayBetween = TimeUnit.HOURS.convert(diff, TimeUnit.MILLISECONDS);
                    break;
                case minute:
                    dayBetween = TimeUnit.MINUTES.convert(diff, TimeUnit.MILLISECONDS);
                    break;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dayBetween;
    }
}
