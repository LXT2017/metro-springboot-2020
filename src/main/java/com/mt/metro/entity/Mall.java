package com.mt.metro.entity;

public class Mall {
    private Integer id;

    private String name;

    private String introduction;

    private String picUrl;

    private Integer price;

    private Integer capacity;

    private Integer remainingCapacity;

    public Mall(Integer id, String name, String introduction, String picUrl, Integer price, Integer capacity, Integer remainingCapacity) {
        this.id = id;
        this.name = name;
        this.introduction = introduction;
        this.picUrl = picUrl;
        this.price = price;
        this.capacity = capacity;
        this.remainingCapacity = remainingCapacity;
    }

    public Mall() {
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

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl == null ? null : picUrl.trim();
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getRemainingCapacity() {
        return remainingCapacity;
    }

    public void setRemainingCapacity(Integer remainingCapacity) {
        this.remainingCapacity = remainingCapacity;
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
        sb.append(", picUrl=").append(picUrl);
        sb.append(", price=").append(price);
        sb.append(", capacity=").append(capacity);
        sb.append(", remainingCapacity=").append(remainingCapacity);
        sb.append("]");
        return sb.toString();
    }
}