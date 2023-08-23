package com.example.writeagain.javabean;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Subject {
    private int id;
    @NotBlank(message = "分类名不能为空")
    private String title;
    private int parentId;
    private Date gmtCreated;
    private Date gmtModified;
    private boolean isInserted;
    private List<Course> courseList;

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public boolean isInserted() {
        return isInserted;
    }

    public void setInserted(boolean inserted) {
        isInserted = inserted;
    }

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
                ", parentId=" + parentId +
                ", gmtCreated=" + gmtCreated +
                ", gmtModified=" + gmtModified +
                ", isInserted=" + isInserted +
                '}';
    }
}
