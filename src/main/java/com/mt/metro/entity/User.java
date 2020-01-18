package com.mt.metro.entity;

public class User {
    private Integer id;

    private Integer uId;

    private String nickname;

    private Integer cityId;

    private String statement;

    public User(Integer id, Integer uId, String nickname, Integer cityId, String statement) {
        this.id = id;
        this.uId = uId;
        this.nickname = nickname;
        this.cityId = cityId;
        this.statement = statement;
    }

    public User() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement == null ? null : statement.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", uId=").append(uId);
        sb.append(", nickname=").append(nickname);
        sb.append(", cityId=").append(cityId);
        sb.append(", statement=").append(statement);
        sb.append("]");
        return sb.toString();
    }
}