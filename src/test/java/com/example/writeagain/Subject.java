package com.example.writeagain;

import java.util.Date;

public class Subject {
    private int id;
    private String title;
    private int parentId;
    private Date gmtCreated;
    private Date gmtModified;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public Date getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", parentId='" + parentId + '\'' +
                ", gmtCreated=" + gmtCreated +
                ", gmtModified=" + gmtModified +
                '}';
    }

    public Subject(int id, String title, int parentId, Date gmtCreated, Date gmtModified) {
        this.id = id;
        this.title = title;
        this.parentId = parentId;
        this.gmtCreated = gmtCreated;
        this.gmtModified = gmtModified;
    }
    public Subject() {}
}

