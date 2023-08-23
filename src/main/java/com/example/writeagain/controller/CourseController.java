package com.example.writeagain.controller;

import com.example.writeagain.javabean.Course;
import com.example.writeagain.vo.CourseBeforeSubmit;
import com.example.writeagain.vo.CourseCountOfSubject;
import com.example.writeagain.vo.CourseListCondition;
import com.example.writeagain.service.CourseService;
import com.example.writeagain.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService service;

    @RequestMapping("/addCourse")
    public Result addCourse(@Valid Course course, String des) {
        int courseId = service.addCourse(course, des);
        return Result.ok(courseId);
    }

    @RequestMapping("/getCourseByCourseId/{courseId}")
    public Result getCourseByCourseId(@PathVariable Integer courseId) {
        Course course = service.getCourseByCourseId(courseId);
        return Result.ok(course);
    }

    @RequestMapping("/updateCourse")
    public Result updateCourse(@Valid Course course, String des) {
        service.updateCourse(course, des);
        return Result.ok(null);
    }

    @RequestMapping("/getCourseBeforeSubmit/{id}")
    public Result getCourseBeforeSubmit(@PathVariable int id){
        CourseBeforeSubmit course = service.getCourseBeforeSubmit(id);
        return Result.ok(course);
    }

    @RequestMapping("/submitCourse/{id}")
    public Result submitCourse(@PathVariable int id){
        service.submitCourse(id);
        return Result.ok(null);
    }

    @RequestMapping("/getCourseList/{currentPage}")
    public Result getCourseList(@PathVariable Integer currentPage,@RequestBody CourseListCondition condition){
        List<CourseBeforeSubmit> courseList =  service.getCourseList(currentPage,condition);
        return Result.ok(courseList);
    }

    @RequestMapping("/saveCourse/{id}")
    public Result saveCourse(@PathVariable int id){
        service.saveCourse(id);
        return Result.ok(null);
    }
    @RequestMapping("/getCourseListTotal")
    public Result getCourseListTotal(@RequestBody CourseListCondition condition){
        int total = service.getCourseListTotal(condition);
        return Result.ok(total);
    }

    @RequestMapping("/deleteCourse/{id}")
    public Result deleteCourse(@PathVariable int id){
        service.deleteCourse(id);
        return Result.ok(null);
    }

    @RequestMapping("/getCourseCount")
    public Result getCourseCount(){
        List<CourseCountOfSubject> countList = service.getCourseCount();
        return Result.ok(countList);
    }

}
