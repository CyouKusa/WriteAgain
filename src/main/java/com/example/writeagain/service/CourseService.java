package com.example.writeagain.service;

import com.example.writeagain.javabean.Course;
import com.example.writeagain.vo.CourseBeforeSubmit;
import com.example.writeagain.vo.CourseCountOfSubject;
import com.example.writeagain.vo.CourseListCondition;
import com.example.writeagain.vo.CourseResult;

import java.util.List;

public interface CourseService {
    int addCourse(Course course, String des);

    Course getCourseByCourseId(int courseId);

    void updateCourse(Course course, String des);

    CourseBeforeSubmit getCourseBeforeSubmit(int id);

    void submitCourse(int id);

    List<CourseBeforeSubmit> getCourseList(Integer currentPage,CourseListCondition condition);

    void saveCourse(int id);

    void deleteCourse(int id);

    int getCourseListTotal(CourseListCondition condition);

    List<CourseCountOfSubject> getCourseCount();
}
