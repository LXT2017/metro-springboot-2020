package com.mt.metroadmin.entity;

public class AchieveOwner {
    private Integer id;

    private Integer userId;

    private Integer category;

    private Integer progress;

    private Integer isReach;

    private Integer achievementId;

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

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public Integer getProgress() {
        return progress;
    }

    public void setProgress(Integer progress) {
        this.progress = progress;
    }

    public Integer getIsReach() {
        return isReach;
    }

    public void setIsReach(Integer isReach) {
        this.isReach = isReach;
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
        sb.append(", category=").append(category);
        sb.append(", progress=").append(progress);
        sb.append(", isReach=").append(isReach);
        sb.append(", achievementId=").append(achievementId);
        sb.append("]");
        return sb.toString();
    }
}