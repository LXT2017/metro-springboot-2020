package com.mt.metro.entity;

public class Game {
    private Integer id;

    private Integer maxDistance;

    private Integer maxScore;

    private Integer totalDistance;

    private Integer userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMaxDistance() {
        return maxDistance;
    }

    public void setMaxDistance(Integer maxDistance) {
        this.maxDistance = maxDistance;
    }

    public Integer getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(Integer maxScore) {
        this.maxScore = maxScore;
    }

    public Integer getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance(Integer totalDistance) {
        this.totalDistance = totalDistance;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", maxDistance=").append(maxDistance);
        sb.append(", maxScore=").append(maxScore);
        sb.append(", totalDistance=").append(totalDistance);
        sb.append(", userId=").append(userId);
        sb.append("]");
        return sb.toString();
    }
}