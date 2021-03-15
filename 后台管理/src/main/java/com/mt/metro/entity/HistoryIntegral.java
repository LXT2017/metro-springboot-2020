package com.mt.metro.entity;

import java.util.Date;

public class HistoryIntegral {
    private Integer id;

    private Integer num;

    private Date hDate;

    private String reason;

    private Integer userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Date gethDate() {
        return hDate;
    }

    public void sethDate(Date hDate) {
        this.hDate = hDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
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
        sb.append(", num=").append(num);
        sb.append(", hDate=").append(hDate);
        sb.append(", reason=").append(reason);
        sb.append(", userId=").append(userId);
        sb.append("]");
        return sb.toString();
    }
}