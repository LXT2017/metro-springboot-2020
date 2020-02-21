package com.mt.metro.entity;

import lombok.Data;

@Data
public class AchieveResponse {
    private Integer id;

    private String progress;

    private String name;

    private String achieveUrl;

    private Integer condition;

    private Boolean isReach;

    private Integer reward;

    private Integer kind;
}
