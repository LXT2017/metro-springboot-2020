package com.mt.metro.entity;

import java.util.Date;

public class PicPuzzle {
    private Integer id;

    private String name;

    private String introduction;

    private String chipUrl;

    private String picUrl;

    private Integer score;

    private Date pTime;

    public PicPuzzle(Integer id, String name, String introduction, String chipUrl, String picUrl, Integer score, Date pTime) {
        this.id = id;
        this.name = name;
        this.introduction = introduction;
        this.chipUrl = chipUrl;
        this.picUrl = picUrl;
        this.score = score;
        this.pTime = pTime;
    }

    public PicPuzzle() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

    public String getChipUrl() {
        return chipUrl;
    }

    public void setChipUrl(String chipUrl) {
        this.chipUrl = chipUrl == null ? null : chipUrl.trim();
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl == null ? null : picUrl.trim();
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Date getpTime() {
        return pTime;
    }

    public void setpTime(Date pTime) {
        this.pTime = pTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", introduction=").append(introduction);
        sb.append(", chipUrl=").append(chipUrl);
        sb.append(", picUrl=").append(picUrl);
        sb.append(", score=").append(score);
        sb.append(", pTime=").append(pTime);
        sb.append("]");
        return sb.toString();
    }
}