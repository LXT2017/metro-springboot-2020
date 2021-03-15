package com.mt.metroadmin.entity;

import java.util.Date;

public class HistoryPuzzle {
    private Integer id;

    private Date completeTime;

    private Date completeDate;

    private Integer userId;

    private Integer puzzleId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCompleteTime() {
        return completeTime;
    }

    public void setCompleteTime(Date completeTime) {
        this.completeTime = completeTime;
    }

    public Date getCompleteDate() {
        return completeDate;
    }

    public void setCompleteDate(Date completeDate) {
        this.completeDate = completeDate;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPuzzleId() {
        return puzzleId;
    }

    public void setPuzzleId(Integer puzzleId) {
        this.puzzleId = puzzleId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", completeTime=").append(completeTime);
        sb.append(", completeDate=").append(completeDate);
        sb.append(", userId=").append(userId);
        sb.append(", puzzleId=").append(puzzleId);
        sb.append("]");
        return sb.toString();
    }
}