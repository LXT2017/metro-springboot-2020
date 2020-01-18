package com.mt.metro.entity;

import java.util.Date;

public class Feedback {
    private Integer id;

    private String content;

    private Date fDate;

    private Integer userId;

    public Feedback(Integer id, String content, Date fDate, Integer userId) {
        this.id = id;
        this.content = content;
        this.fDate = fDate;
        this.userId = userId;
    }

    public Feedback() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getfDate() {
        return fDate;
    }

    public void setfDate(Date fDate) {
        this.fDate = fDate;
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
        sb.append(", content=").append(content);
        sb.append(", fDate=").append(fDate);
        sb.append(", userId=").append(userId);
        sb.append("]");
        return sb.toString();
    }
}