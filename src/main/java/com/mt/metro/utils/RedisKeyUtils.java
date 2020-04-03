package com.mt.metro.utils;

public class RedisKeyUtils {

    public static final String MAP_KEY_TOTAL_LOGIN = "MAP_KEY_TOTAL_LOGIN";
    //保存各个城市的登录数据
    public static final String MAP_KEY_USER_CITY_LOGIN = "MAP_KEY_USER_CITY_LOGIN";

    /**
     * redis key的拼接
     */
    public static String getLikedKey(String likedUserId, String likedPostId){
        StringBuilder builder = new StringBuilder();
        builder.append(likedUserId);
        builder.append("::");
        builder.append(likedPostId);
        return builder.toString();
    }

}
