package com.example.writeagain.mapper;

import com.example.writeagain.javabean.Subject;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SubjectMapper {
    List<Subject> getSubjects();

    List<Subject> getParentSubjects();

    List<Subject> getSonSubjects(int id);

    int addSubject(Subject subject);

    /**
     * 根据int集合批量删除课程分类
     * @param idList
     * @return
     */
    int deleteSubjects(List<Integer> idList);

    int[] getChildID(int id);


    Integer getParentIdById(int id);

    Subject getParentById(int id);
}
