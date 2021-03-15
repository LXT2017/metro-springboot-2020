package com.mt.metroadmin.entity;

import java.time.LocalDateTime;

public class Statistic {
    private Integer id;

    private Integer totalnum;

    private Integer citynum;

    private LocalDateTime statime;

    private String city;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTotalnum() {
        return totalnum;
    }

    public void setTotalnum(Integer totalnum) {
        this.totalnum = totalnum;
    }

    public Integer getCitynum() {
        return citynum;
    }

    public void setCitynum(Integer citynum) {
        this.citynum = citynum;
    }

    public LocalDateTime getStatime() {
        return statime;
    }

    public void setStatime(LocalDateTime statime) {
        this.statime = statime;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", totalnum=").append(totalnum);
        sb.append(", citynum=").append(citynum);
        sb.append(", statime=").append(statime);
        sb.append(", city=").append(city);
        sb.append("]");
        return sb.toString();
    }
}