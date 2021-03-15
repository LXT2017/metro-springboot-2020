package com.mt.metroadmin.entity;

public class Prop {
    private Integer id;

    private String name;

    private String propDescribe;

    private String picUrl;

    private String effectUrl;

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

    public String getPropDescribe() {
        return propDescribe;
    }

    public void setPropDescribe(String propDescribe) {
        this.propDescribe = propDescribe == null ? null : propDescribe.trim();
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl == null ? null : picUrl.trim();
    }

    public String getEffectUrl() {
        return effectUrl;
    }

    public void setEffectUrl(String effectUrl) {
        this.effectUrl = effectUrl == null ? null : effectUrl.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", propDescribe=").append(propDescribe);
        sb.append(", picUrl=").append(picUrl);
        sb.append(", effectUrl=").append(effectUrl);
        sb.append("]");
        return sb.toString();
    }
}