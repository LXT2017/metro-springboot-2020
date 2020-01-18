package com.mt.metro.entity;

public class Game {
    private Integer id;

    private Integer maxDistance;

    private Integer maxScore;

    private Integer totalDistance;

    private Integer userId;

    private Integer addition;

    public Game(Integer id, Integer maxDistance, Integer maxScore, Integer totalDistance, Integer userId, Integer addition) {
        this.id = id;
        this.maxDistance = maxDistance;
        this.maxScore = maxScore;
        this.totalDistance = totalDistance;
        this.userId = userId;
        this.addition = addition;
    }

    public Game() {
        super();
    }

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

    public Integer getAddition() {
        return addition;
    }

    public void setAddition(Integer addition) {
        this.addition = addition;
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
        sb.append(", addition=").append(addition);
        sb.append("]");
        return sb.toString();
    }
}