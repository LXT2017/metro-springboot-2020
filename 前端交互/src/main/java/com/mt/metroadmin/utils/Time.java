package com.mt.metroadmin.utils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class Time {


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
     * 返回距离多少天前的日期
     */
    public static String getBeforeDaysTime(int days){
        LocalDateTime rightNow = LocalDateTime.now();
        LocalDateTime beforeTime = rightNow.minusDays(days);
        String dateString = beforeTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        return dateString;
    }
}
