package com.mt.metroadmin.entity;

public class Friend {
    private Integer friend1;

    private Integer friend2;

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", friend1=").append(friend1);
        sb.append(", friend2=").append(friend2);
        sb.append("]");
        return sb.toString();
    }
}