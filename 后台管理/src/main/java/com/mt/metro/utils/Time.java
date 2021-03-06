package com.mt.metro.utils;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class Time {




    // 根据日期取得星期几
    public static int getWeek(){
        LocalDateTime currentTime = LocalDateTime.now();
        int i = 0;
        switch (currentTime.getDayOfWeek().toString()){
            case "MONDAY":i = 1;break;
            case "TUESDAY":i = 2;break;
            case "WEDNESDAY":i = 3;break;
            case "THURSDAY":i = 4;break;
            case "FRIDAY":i = 5;break;
            case "SATURDAY":i = 6;break;
            case "SUNDAY":i = 7;break;
        }
       return i;
    }


    /**
     *
     * 剩余一周的时间
     * @return
     */
    public static int getRefreshWeekTime(){

        int time = getRefreshTime()+(7-getWeek())*3600*24;
        return time;

    }


    /**
     * 获取当前时间离明天凌晨还有多少小时
     *
     * @return
     */
    public static int getRefreshTime() {
        Calendar calendar = Calendar.getInstance();
        int now = (int) (calendar.getTimeInMillis() / 1000);
        calendar.add(Calendar.DATE, 1);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        return (int) (calendar.getTimeInMillis() / 1000 - now);
    }


    /**
     * 获取当前日期
     *
     * @return
     */
    public static String getCurrentDate() {
        LocalDateTime rightNow = LocalDateTime.now();
        System.out.println(rightNow);
        String result = rightNow.format(DateTimeFormatter.BASIC_ISO_DATE);
        return result;
    }


    /**
     * String
     * 获取准确的信息储存到数据库
     */
    public static String getCurrentTime() {
        LocalDateTime date = LocalDateTime.now();
        // 获取今天的日期
        String dateString = date.format(DateTimeFormatter.ofPattern("yyyyMMddHHMMss"));
        return dateString;
    }


    /**
     * LocalDateTime==>Date
     * 获取准确的信息储存到数据库
     */
    public static Date getDateCurrentTime() {
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.now();
        ZonedDateTime zdt = localDateTime.atZone(zoneId);

        Date date = Date.from(zdt.toInstant());

        System.out.println("LocalDateTime = " + localDateTime);
        System.out.println("Date = " + date);
        return date;
    }


    /**
     * Date==>LocalDateTime
     * 获取准确的信息储存到数据库
     */
    public static LocalDateTime getLocalDateCurrentTime() {
        Date date = new Date();
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();

        LocalDateTime localDateTime = instant.atZone(zoneId).toLocalDateTime();
        System.out.println("Date = " + date);
        System.out.println("LocalDateTime = " + localDateTime);
        return localDateTime;
    }


    /**
     * 获得当前日期
     * 已过期
     */
    public static String getCurrentDate1() {
        Date date = new Date();
        // 获取今天的日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String dateString = sdf.format(date);
        return dateString;
    }
}
