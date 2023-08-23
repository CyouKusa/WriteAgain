package com.example.writeagain.mapper;

import com.example.writeagain.javabean.Course;
import com.example.writeagain.vo.CourseBeforeSubmit;
import com.example.writeagain.vo.CourseCountOfSubject;
import com.example.writeagain.vo.CourseListCondition;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CourseMapper {
    int addCourse(Course course);

    Course getCourseByCourseId(int courseId);

    Course getCourse(int courseId);

    int updateCourse(Course course);

    CourseBeforeSubmit getCourseBeforeSubmit(int id);

    int submitCourse(Course course);

    List<CourseBeforeSubmit> getCourseList(@Param("startIndex") Integer startIndex,@Param("pagesize") Integer pagesize,@Param("condition") CourseListCondition condition);

    int deleteCourse(int id);

    int getCourseListTotal(CourseListCondition condition);

    List<CourseCountOfSubject> getCourseCount();
}
