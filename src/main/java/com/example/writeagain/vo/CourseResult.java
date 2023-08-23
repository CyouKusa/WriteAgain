package com.example.writeagain.vo;

import com.example.writeagain.javabean.Course;
import com.example.writeagain.javabean.CourseDes;
import com.example.writeagain.javabean.Subject;

import java.util.Arrays;
import java.util.List;

public class  CourseResult {
    private Course course;
    private CourseDes courseDes;
    private List<Integer> subjectIds;

    public List<Integer> getSubjectIds() {
        return subjectIds;
    }

    public void setSubjectIds(List<Integer> subjectIds) {
        this.subjectIds = subjectIds;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public CourseDes getCourseDes() {
        return courseDes;
    }

    public void setCourseDes(CourseDes courseDes) {
        this.courseDes = courseDes;
    }

    @Override
    public String toString() {
        return "CourseResult{" +
                "course=" + course +
                ", courseDes=" + courseDes +
                ", subjectIds=" + subjectIds +
                '}';
    }

    public CourseResult(Course course, CourseDes courseDes, List<Integer> subjectIds) {
        this.course = course;
        this.courseDes = courseDes;
        this.subjectIds = subjectIds;
    }
}
