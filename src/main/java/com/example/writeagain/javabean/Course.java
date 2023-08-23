package com.example.writeagain.javabean;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Course {
    private Integer id;
    @NotNull(message = "请选择教师")
    private Integer teacherId;
    @NotNull(message = "请选择课程")
    private Integer subjectId;

    @NotBlank(message = "请填写课程名")
    private String title;
    private Long price;
    @NotBlank(message = "请输入课时数")
    private String lessonNum;
    @NotBlank(message = "请上传一张封面")
    private String cover;
    private Long buyCount;
    private Long viewCount;
    private CourseStatus status;
    private Date gmtCreated;
    private Date gmtModified;
    private CourseDes courseDes;
    private List<Integer> subjectParents;
    private List<Chapter> chapterList;

    public List<Integer> getSubjectParents() {
        return subjectParents;
    }

    public void setSubjectParents(List<Integer> subjectParents) {
        this.subjectParents = subjectParents;
    }

    public List<Chapter> getChapterList() {
        return chapterList;
    }

    public void setChapterList(List<Chapter> chapterList) {
        this.chapterList = chapterList;
    }

    public CourseDes getCourseDes() {
        return courseDes;
    }

    public void setCourseDes(CourseDes courseDes) {
        this.courseDes = courseDes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public String getTitle() {
        return title;
    }
    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getLessonNum() {
        return lessonNum;
    }

    public void setLessonNum(String lessonNum) {
        this.lessonNum = lessonNum;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public Long getBuyCount() {
        return buyCount;
    }

    public void setBuyCount(Long buyCount) {
        this.buyCount = buyCount;
    }

    public Long getViewCount() {
        return viewCount;
    }

    public void setViewCount(Long viewCount) {
        this.viewCount = viewCount;
    }

    public CourseStatus getStatus() {
        return status;
    }

    public void setStatus(CourseStatus status) {
        this.status = status;
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
        return "Course{" +
                "id=" + id +
                ", teacherId=" + teacherId +
                ", subjectId=" + subjectId +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", lessonNum='" + lessonNum + '\'' +
                ", cover='" + cover + '\'' +
                ", buyCount=" + buyCount +
                ", viewCount=" + viewCount +
                ", status=" + status +
                ", gmtCreated=" + gmtCreated +
                ", gmtModified=" + gmtModified +
                '}';
    }
}
