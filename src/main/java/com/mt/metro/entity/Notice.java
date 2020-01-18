package com.mt.metro.entity;

import java.util.Date;

public class Notice {
    private Integer id;

    private String content;

    private Date noticeDate;

    public Notice(Integer id, String content, Date noticeDate) {
        this.id = id;
        this.content = content;
        this.noticeDate = noticeDate;
    }

    public Notice() {
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

    public Date getNoticeDate() {
        return noticeDate;
    }

    public void setNoticeDate(Date noticeDate) {
        this.noticeDate = noticeDate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", content=").append(content);
        sb.append(", noticeDate=").append(noticeDate);
        sb.append("]");
        return sb.toString();
    }
}