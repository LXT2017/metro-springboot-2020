package com.mt.metro.common;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class Time {

    /**
     * 获取当前时间离明天凌晨还有多少小时
     * @return
     */
    public static int getRefreshTime(){
        Calendar calendar = Calendar.getInstance();
        int now = (int) (calendar.getTimeInMillis()/1000);
        calendar.add(Calendar.DATE, 1);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.HOUR_OF_DAY , 0);
        return (int) (calendar.getTimeInMillis()/1000-now);
    }


    /**
     * 获取当前日期
     * @return
     */
    public static String getCurrentDate(){
        LocalDateTime rightNow = LocalDateTime.now();
        System.out.println(rightNow);
        String result = rightNow.format(DateTimeFormatter.BASIC_ISO_DATE);
        return result;
    }



    /**
     * 获取准确的信息储存到数据库
     */
    public static String getCurrentTime(){
        LocalDateTime date = LocalDateTime.now();
        // 获取今天的日期
        String dateString = date.format(DateTimeFormatter.ofPattern("yyyyMMddHHMMss"));
        return dateString;
    }


    /**
     * 获得当前日期
     * 已过期
     */
    public static String getCurrentDate1(){
        Date date = new Date();
        // 获取今天的日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String dateString = sdf.format(date);
        return dateString;
    }
}
