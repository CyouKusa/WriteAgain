package com.example.writeagain.vo;

import com.example.writeagain.javabean.CourseStatus;
import com.example.writeagain.javabean.Subject;

import java.util.List;

public class CourseBeforeSubmit {
    private Integer id;
    private String title;
    private String cover;
    private Integer videoCount;
    private String teacherName;
    private Long price;
    private List<Subject> subjects;
    private String subject;
    private CourseStatus status;
    private int buyCount;
    private int viewCount;

    @Override
    public String toString() {
        return "CourseBeforeSubmit{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", cover='" + cover + '\'' +
                ", videoCount=" + videoCount +
                ", teacherName='" + teacherName + '\'' +
                ", price=" + price +
                ", subjects=" + subjects +
                ", subject=" + subject +
                ", status=" + status +
                ", buyCount=" + buyCount +
                ", viewCount=" + viewCount +
                '}';
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public CourseStatus getStatus() {
        return status;
    }

    public void setStatus(CourseStatus status) {
        this.status = status;
    }

    public int getBuyCount() {
        return buyCount;
    }

    public void setBuyCount(int buyCount) {
        this.buyCount = buyCount;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getVideoCount() {
        return videoCount;
    }

    public void setVideoCount(Integer videoCount) {
        this.videoCount = videoCount;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }


}
