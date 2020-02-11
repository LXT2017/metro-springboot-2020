package com.mt.metro.entity;

public class Achievement {
    private Integer id;

    private String name;

    private String achieveUrl;

    private Integer requirement;

    private String category;

    private Integer reward;

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

    public String getAchieveUrl() {
        return achieveUrl;
    }

    public void setAchieveUrl(String achieveUrl) {
        this.achieveUrl = achieveUrl == null ? null : achieveUrl.trim();
    }

    public Integer getRequirement() {
        return requirement;
    }

    public void setRequirement(Integer requirement) {
        this.requirement = requirement;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    public Integer getReward() {
        return reward;
    }

    public void setReward(Integer reward) {
        this.reward = reward;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", achieveUrl=").append(achieveUrl);
        sb.append(", requirement=").append(requirement);
        sb.append(", category=").append(category);
        sb.append(", reward=").append(reward);
        sb.append("]");
        return sb.toString();
    }
}