package com.example.writeagain.vo;

import java.util.Date;

public class Condition {
    private String name;
    private int level;
    private Date startTime;
    private Date endTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
    public Condition getCondition() {
        return null;
    }

    @Override
    public String toString() {
        return "Condition{" +
                "name='" + name + '\'' +
                ", level=" + level +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
