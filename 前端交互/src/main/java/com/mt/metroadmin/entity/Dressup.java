package com.mt.metroadmin.entity;

public class Dressup {
    private Integer id;

    private String dressUrl;

    private Integer price;

    private Integer dressupId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDressUrl() {
        return dressUrl;
    }

    public void setDressUrl(String dressUrl) {
        this.dressUrl = dressUrl == null ? null : dressUrl.trim();
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
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
        sb.append(", dressUrl=").append(dressUrl);
        sb.append(", price=").append(price);
        sb.append(", dressupId=").append(dressupId);
        sb.append("]");
        return sb.toString();
    }
}