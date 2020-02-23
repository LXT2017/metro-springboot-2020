package com.mt.metro.entity;

public class Game {
    private Integer id;

    private Integer entertainment;

    private Integer bodybuilding;

    private Integer speedcontest;

    private Integer userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEntertainment() {
        return entertainment;
    }

    public void setEntertainment(Integer entertainment) {
        this.entertainment = entertainment;
    }

    public Integer getBodybuilding() {
        return bodybuilding;
    }

    public void setBodybuilding(Integer bodybuilding) {
        this.bodybuilding = bodybuilding;
    }

    public Integer getSpeedcontest() {
        return speedcontest;
    }

    public void setSpeedcontest(Integer speedcontest) {
        this.speedcontest = speedcontest;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", entertainment=").append(entertainment);
        sb.append(", bodybuilding=").append(bodybuilding);
        sb.append(", speedcontest=").append(speedcontest);
        sb.append(", userId=").append(userId);
        sb.append("]");
        return sb.toString();
    }
}