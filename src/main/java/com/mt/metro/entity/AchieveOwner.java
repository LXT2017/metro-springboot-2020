package com.mt.metro.entity;

public class AchieveOwner {
    private Integer id;

    private Integer userId;

    private Integer achievementId;

    public AchieveOwner(Integer id, Integer userId, Integer achievementId) {
        this.id = id;
        this.userId = userId;
        this.achievementId = achievementId;
    }

    public AchieveOwner() {
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

    public Integer getAchievementId() {
        return achievementId;
    }

    public void setAchievementId(Integer achievementId) {
        this.achievementId = achievementId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", achievementId=").append(achievementId);
        sb.append("]");
        return sb.toString();
    }
}