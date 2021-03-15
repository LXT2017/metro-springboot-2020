package com.mt.metroadmin.entity;

public class Achievement {
    private Integer id;

    private String name;

    private String achieveUrl;

    private Integer condition;

    private Integer category;

    private Integer reward;

    private Integer kind;

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

    public Integer getCondition() {
        return condition;
    }

    public void setCondition(Integer condition) {
        this.condition = condition;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public Integer getReward() {
        return reward;
    }

    public void setReward(Integer reward) {
        this.reward = reward;
    }

    public Integer getKind() {
        return kind;
    }

    public void setKind(Integer kind) {
        this.kind = kind;
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
        sb.append(", condition=").append(condition);
        sb.append(", category=").append(category);
        sb.append(", reward=").append(reward);
        sb.append(", kind=").append(kind);
        sb.append("]");
        return sb.toString();
    }
}