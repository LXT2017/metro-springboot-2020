package com.mt.metro.entity;

public class CarbonRanking {
    private Integer id;

    private Integer dailyScore;

    private Integer weekScore;

    private Integer totalScore;

    private Integer dailyRanking;

    private Integer weekRanking;

    private Integer userId;

    public CarbonRanking(Integer dailyScore, Integer weekScore, Integer totalScore, Integer dailyRanking, Integer weekRanking) {
        this.dailyScore = dailyScore;
        this.weekScore = weekScore;
        this.totalScore = totalScore;
        this.dailyRanking = dailyRanking;
        this.weekRanking = weekRanking;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDailyScore() {
        return dailyScore;
    }

    public void setDailyScore(Integer dailyScore) {
        this.dailyScore = dailyScore;
    }

    public Integer getWeekScore() {
        return weekScore;
    }

    public void setWeekScore(Integer weekScore) {
        this.weekScore = weekScore;
    }

    public Integer getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Integer totalScore) {
        this.totalScore = totalScore;
    }

    public Integer getDailyRanking() {
        return dailyRanking;
    }

    public void setDailyRanking(Integer dailyRanking) {
        this.dailyRanking = dailyRanking;
    }

    public Integer getWeekRanking() {
        return weekRanking;
    }

    public void setWeekRanking(Integer weekRanking) {
        this.weekRanking = weekRanking;
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
        sb.append(", dailyScore=").append(dailyScore);
        sb.append(", weekScore=").append(weekScore);
        sb.append(", totalScore=").append(totalScore);
        sb.append(", dailyRanking=").append(dailyRanking);
        sb.append(", weekRanking=").append(weekRanking);
        sb.append(", userId=").append(userId);
        sb.append("]");
        return sb.toString();
    }
}