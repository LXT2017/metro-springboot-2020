package com.mt.metro.entity;

public class Dressup {
    private Integer id;

    private String dressUrl;

    private Integer price;

    private Integer dressupName;

    private Integer dressupId;

    public Dressup(Integer id, String dressUrl, Integer price, Integer dressupName, Integer dressupId) {
        this.id = id;
        this.dressUrl = dressUrl;
        this.price = price;
        this.dressupName = dressupName;
        this.dressupId = dressupId;
    }

    public Dressup() {
        super();
    }

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

    public Integer getDressupName() {
        return dressupName;
    }

    public void setDressupName(Integer dressupName) {
        this.dressupName = dressupName;
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
        sb.append(", dressupName=").append(dressupName);
        sb.append(", dressupId=").append(dressupId);
        sb.append("]");
        return sb.toString();
    }
}