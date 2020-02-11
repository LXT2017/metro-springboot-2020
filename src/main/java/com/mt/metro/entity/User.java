package com.mt.metro.entity;

public class User {
    private Integer id;

    private Integer uId;

    //男1女2
    private Integer gender;

    private String nickname;

    private String city;

    private String statement;

    private String defaultStation;

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

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement == null ? null : statement.trim();
    }

    public String getDefaultStation() {
        return defaultStation;
    }

    public void setDefaultStation(String defaultStation) {
        this.defaultStation = defaultStation == null ? null : defaultStation.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", uId=").append(uId);
        sb.append(", gender=").append(gender);
        sb.append(", nickname=").append(nickname);
        sb.append(", city=").append(city);
        sb.append(", statement=").append(statement);
        sb.append(", defaultStation=").append(defaultStation);
        sb.append("]");
        return sb.toString();
    }
}