package com.example.writeagain.vo;

public class CourseListCondition {
    private String courseName;
    private String status;
    private String TeacherName;
    private Integer subjectId;

    @Override
    public String toString() {
        return "CourseListCondition{" +
                "courseName='" + courseName + '\'' +
                ", status='" + status + '\'' +
                ", TeacherName='" + TeacherName + '\'' +
                ", subjectId=" + subjectId +
                '}';
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTeacherName() {
        return TeacherName;
    }

    public void setTeacherName(String teacherName) {
        TeacherName = teacherName;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }
}
