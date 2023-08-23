package com.example.writeagain.controller;

import com.example.writeagain.javabean.Teacher;
import com.example.writeagain.service.TeacherService;
import com.example.writeagain.vo.Condition;
import com.example.writeagain.vo.Result;
import com.example.writeagain.vo.TeacherList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/teacher")
@Validated

public class TeacherController {

    @Autowired
    private TeacherService service;

    @RequestMapping("/addTeacher")
    public Result addTeacher(@Valid @RequestBody Teacher teacher){
        service.addTeacher(teacher);
        return Result.ok(null);
    }

    @RequestMapping("/showTeacherByPage/{currentPage}")
    public Result showTeacherByPage(@PathVariable int currentPage,@RequestBody Condition condition){
        TeacherList teacherList =service.showTeacherByPage  (currentPage,condition);
        return Result.ok(teacherList);
    }

    @RequestMapping("/deleteTeacher/{id}")
    public Result deleteTeacher(@PathVariable Integer id){
        service.deleteTeacher(id);
        return Result.ok(null);
    }

    @RequestMapping("/findTeacherById/{id}")
    public Result findTeacherById(@PathVariable Integer id){
        Teacher teacher = service.findTeacherById(id);
        return Result.ok(teacher);
    }

    @RequestMapping("/updateTeacher")
    public Result updateTeacher(@Valid @RequestBody Teacher teacher){
        service.updateTeacher(teacher);
        return Result.ok(null);
    }

    @RequestMapping("/deleteSelected")
    public Result deleteSelected(int[] ids){
        service.deleteSelected(ids);
        return Result.ok(null);
    }

    @RequestMapping("/selectTeacherAll")
    public Result selectTeacherAll(){
        List<Teacher> list= service.selectTeacherAll();
        return Result.ok(list);
    }



}
