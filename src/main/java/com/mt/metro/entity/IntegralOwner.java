package com.mt.metro.entity;

public class IntegralOwner {
    private Integer id;

    private Integer userId;

    private Integer mallId;

    public IntegralOwner(Integer id, Integer userId, Integer mallId) {
        this.id = id;
        this.userId = userId;
        this.mallId = mallId;
    }

    public IntegralOwner() {
        super();
    }

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

    public Integer getMallId() {
        return mallId;
    }

    public void setMallId(Integer mallId) {
        this.mallId = mallId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", mallId=").append(mallId);
        sb.append("]");
        return sb.toString();
    }
}