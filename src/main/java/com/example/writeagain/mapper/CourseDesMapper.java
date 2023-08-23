package com.example.writeagain.mapper;

import com.example.writeagain.javabean.CourseDes;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CourseDesMapper {
    int addCourseDes(CourseDes courseDes);

    CourseDes getCourseDesByCourseId(int courseId);

    int updateCourseDes(CourseDes courseDes);

    int deleteCourseDes(int id);
}
