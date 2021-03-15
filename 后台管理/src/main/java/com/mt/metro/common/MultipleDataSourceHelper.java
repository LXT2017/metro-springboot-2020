package com.mt.metro.common;

public class MultipleDataSourceHelper {
    public static final String MASTER1 = "master1";
    public static final String MASTER = "master";
    public static final String SLAVE = "slave";

    private static ThreadLocal<String> contextHolder = new ThreadLocal<>();

    public static void set(String db) {
        contextHolder.set(db);
    }

    public static String get() {
        return contextHolder.get();
    }

}