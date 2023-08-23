package com.example.writeagain.service.Impl;

import com.example.writeagain.javabean.Course;
import com.example.writeagain.javabean.CourseDes;
import com.example.writeagain.javabean.Subject;
import com.example.writeagain.mapper.*;
import com.example.writeagain.vo.*;
import com.example.writeagain.javabean.CourseStatus;
import com.example.writeagain.service.CourseService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.example.writeagain.vo.Constant.COURSEPAGESIZE;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseDesMapper desMapper;
    @Autowired
    private CourseMapper mapper;
    @Autowired
    private SubjectMapper subjectMapper;
    @Autowired
    private ChapterMapper chapterMapper;
    @Autowired
    private VideoMapper videoMapper;


    @Transactional
    @Override
    public int addCourse(Course course, String des) {
        course.setBuyCount(0l);
        course.setViewCount(0l);
        course.setStatus(CourseStatus.Draft);
        Date date = new Date();
        course.setGmtCreated(date);
        course.setGmtModified(date);
        if (des == null) {
            throw new RuntimeException("请填写课程描述");
        }
        int i = mapper.addCourse(course);
        if (i < 1) {
            throw new RuntimeException("添加课程失败");
        }
        CourseDes courseDes = new CourseDes();
        courseDes.setId(course.getId());
        courseDes.setDes(des);
        courseDes.setGmtCreated(date);
        courseDes.setGmtModified(date);
        int j = desMapper.addCourseDes(courseDes);
        if (j < 1) {
            throw new RuntimeException("添加课程失败");
        }
        return course.getId();
    }

    @Transactional
    @Override
    public Course getCourseByCourseId(int courseId) {
//        Course course = mapper.getCourseByCourseId(courseId);
//        CourseDes courseDes = desMapper.getCourseDesByCourseId(courseId);
//        List<Integer> subjectIds = new ArrayList<Integer>();
        Course course = mapper.getCourse(courseId);
        List<Integer> subjectIds = new ArrayList<Integer>();
        getParentId(course.getSubjectId(), subjectIds);
        subjectIds.add(course.getSubjectId());
        course.setSubjectParents(subjectIds);
        return course;
    }

    @Override
    public void updateCourse(Course course, String des) {
        if (des == null) {
            throw new RuntimeException("请填写课程描述");
        }
        course.setGmtModified(new Date());
        int i = mapper.updateCourse(course);
        if (i < 1) {
            throw new RuntimeException("修改课程失败");
        }
        CourseDes courseDes = new CourseDes();
        courseDes.setId(course.getId());
        courseDes.setDes(des);
        courseDes.setGmtModified(new Date());
        int j = desMapper.updateCourseDes(courseDes);
        if (j < 1) {
            throw new RuntimeException("添加课程失败");
        }
    }

    @Override
    public CourseBeforeSubmit getCourseBeforeSubmit(int id) {
        CourseBeforeSubmit course = mapper.getCourseBeforeSubmit(id);
        int subjectId = mapper.getCourseByCourseId(id).getSubjectId();
        List<Subject> subjects = new ArrayList<Subject>();
        getParents(subjectId, subjects);
        course.setSubjects(subjects);
        return course;
    }

    @Override
    public void submitCourse(int id) {
        Course course = new Course();
        course.setId(id);
        course.setStatus(CourseStatus.Normal);
        int i = mapper.submitCourse(course);
        if (i < 1) {
            throw new RuntimeException("发布课程失败");
        }
    }

    @Override
    public List<CourseBeforeSubmit> getCourseList(Integer currentPage, CourseListCondition condition) {

        List<CourseBeforeSubmit> courses = mapper.getCourseList((currentPage - 1) * COURSEPAGESIZE, COURSEPAGESIZE,
        condition);
        return courses;
    }

    @Override
    public void saveCourse(int id) {
        Course course = new Course();
        course.setId(id);
        course.setStatus(CourseStatus.Draft);
        int i = mapper.submitCourse(course);
        if (i < 1) {
            throw new RuntimeException("保存课程失败");
        }
    }

    @Override
    @Transactional
    public void deleteCourse(int id) {
        int i = mapper.deleteCourse(id);
        if (i < 1) {
            throw new RuntimeException("删除课程失败");
        }
        desMapper.deleteCourseDes(id);
        chapterMapper.deleteChapterByCourseId(id);
        videoMapper.deleteVideoByCourseId(id);
    }

    @Override
    public int getCourseListTotal(CourseListCondition condition) {
        int total = mapper.getCourseListTotal(condition);
        return total;
    }

    @Override
    public List<CourseCountOfSubject> getCourseCount() {
        List<CourseCountOfSubject> courseList = mapper.getCourseCount();
        return courseList;
    }

    private void getParentId(int id, List<Integer> subjectIds) {
        Integer parentId = subjectMapper.getParentIdById(id);
        if (parentId == null) {
            throw new RuntimeException("课程分类已被删除!");
        } else if (parentId == 0) {
        } else {
            getParentId(parentId, subjectIds);
        }
        if (parentId != 0) {
            subjectIds.add(parentId);
        }
    }

    private void getParents(int id, List<Subject> subjects) {
        Subject subject = subjectMapper.getParentById(id);
        subjects.add(0, subject);
        if (subject.getParentId() == 0) {
            return;
        }
        getParents(subject.getParentId(), subjects);
    }
}

