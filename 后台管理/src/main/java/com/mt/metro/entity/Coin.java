package com.mt.metro.entity;

public class Coin {
    private Integer id;

    private Integer coinNumber;

    private Integer userId;

    private Integer weekNumber;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCoinNumber() {
        return coinNumber;
    }

    public void setCoinNumber(Integer coinNumber) {
        this.coinNumber = coinNumber;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getWeekNumber() {
        return weekNumber;
    }

    public void setWeekNumber(Integer weekNumber) {
        this.weekNumber = weekNumber;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", coinNumber=").append(coinNumber);
        sb.append(", userId=").append(userId);
        sb.append(", weekNumber=").append(weekNumber);
        sb.append("]");
        return sb.toString();
    }
}