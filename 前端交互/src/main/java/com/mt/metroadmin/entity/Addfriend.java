package com.mt.metroadmin.entity;

public class Addfriend {
    private Integer friend1;

    private Integer friend2;

    private String friend1Allow;

    private String friend2Allow;

    public Integer getFriend1() {
        return friend1;
    }

    public void setFriend1(Integer friend1) {
        this.friend1 = friend1;
    }

    public Integer getFriend2() {
        return friend2;
    }

    public void setFriend2(Integer friend2) {
        this.friend2 = friend2;
    }

    public String getFriend1Allow() {
        return friend1Allow;
    }

    public void setFriend1Allow(String friend1Allow) {
        this.friend1Allow = friend1Allow == null ? null : friend1Allow.trim();
    }

    public String getFriend2Allow() {
        return friend2Allow;
    }

    public void setFriend2Allow(String friend2Allow) {
        this.friend2Allow = friend2Allow == null ? null : friend2Allow.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", friend1=").append(friend1);
        sb.append(", friend2=").append(friend2);
        sb.append(", friend1Allow=").append(friend1Allow);
        sb.append(", friend2Allow=").append(friend2Allow);
        sb.append("]");
        return sb.toString();
    }
}