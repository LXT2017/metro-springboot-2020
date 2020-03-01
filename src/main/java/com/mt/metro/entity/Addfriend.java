package com.mt.metro.entity;

import lombok.Data;

@Data
public class Addfriend {
    public static final String ALLOW="Y";
    public static final String DISALLOW="N";

    private int id;
    private int friend1;
    private int friend2;
    private String friend1_allow;
    private String friend2_allow;
    private String friendName;
    private String response;

}