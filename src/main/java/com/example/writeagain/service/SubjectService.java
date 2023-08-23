package com.example.writeagain.service;

import com.example.writeagain.javabean.Subject;
import com.example.writeagain.vo.SubjectVo;

import java.util.List;

public interface SubjectService {
    List<SubjectVo> getSubjects();

    void addSubject(Subject subject);

    void deleteSubject(int id);

    /**
     * 查询所有课程分类,并组装成对应格式
     * @return 组装完成的课程分类集合
     */
    List<Subject> selectSubjectAll();
}
