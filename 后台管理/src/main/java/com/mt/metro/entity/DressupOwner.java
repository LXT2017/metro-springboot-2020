package com.mt.metro.entity;

public class DressupOwner {
    private Integer id;

    private Integer userId;

    private Integer dressupId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getDressupId() {
        return dressupId;
    }

    public void setDressupId(Integer dressupId) {
        this.dressupId = dressupId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", dressupId=").append(dressupId);
        sb.append("]");
        return sb.toString();
    }
}