package com.mt.metro.entity;

public class Achievement {
    private Integer id;

    private String name;

    private String achieveUrl;

    private Integer requirement;

    public Achievement(Integer id, String name, String achieveUrl, Integer requirement) {
        this.id = id;
        this.name = name;
        this.achieveUrl = achieveUrl;
        this.requirement = requirement;
    }

    public Achievement() {
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
        sb.append("]");
        return sb.toString();
    }
}