package com.example.writeagain.controller;

import com.example.writeagain.javabean.Subject;
import com.example.writeagain.service.SubjectService;
import com.example.writeagain.vo.Result;
import com.example.writeagain.vo.SubjectVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    private SubjectService service;

    @RequestMapping("/getSubjects")
    public Result getSubjects(){
        List<SubjectVo> subjects = service.getSubjects();
        return Result.ok(subjects);
    }

    @RequestMapping("/addSubject/")
    public Result addSubject(@RequestBody @Valid Subject subject){
        System.out.println(subject);
        service.addSubject(subject);
        return Result.ok(null);
    }

    @RequestMapping("/deleteSubject/{id}")
    public Result deleteSubject(@PathVariable int id){
        service.deleteSubject(id);
        return Result.ok(null);
    }

    @RequestMapping("/selectSubjectAll")
    public Result selectSubjectAll(){
        List<Subject> list = service.selectSubjectAll();
        return Result.ok(list);
    }
}
