package com.example.intercrowded.api.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Timespan {

    String start;
    String end;

    public Timespan(String start, String end) {
        this.start = start;
        this.end = end;
    }

    public Timespan() {
        this.start = convert(new Date());
        this.end =   convert(new Date());
    }

    @Override
    public String toString() {
        return "{" +
                "start:'" + start + '\'' +
                ", end:'" + end + '\'' +
                '}';
    }

    public static String convert(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("UTC"));
        calendar.setTime(date);
        Date time = calendar.getTime();
        SimpleDateFormat outputFmt = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String dateAsString = outputFmt.format(time);
        return dateAsString;
    }
}
