package com.example.writeagain.service.Impl;

import com.example.writeagain.javabean.Subject;
import com.example.writeagain.mapper.SubjectMapper;
import com.example.writeagain.service.SubjectService;
import com.example.writeagain.vo.SubjectVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {
    @Autowired
    private SubjectMapper mapper;

    @Override
    public List<SubjectVo> getSubjects() {
        List<SubjectVo> subjectVo = getSonSubjects(0);
        return subjectVo;
    }

    @Override
    public void addSubject(Subject subject) {
        Date date = new Date();
        subject.setGmtCreated(date);
        subject.setGmtModified(date);
        int i = mapper.addSubject(subject);
        if (i < 1) {
            throw new RuntimeException("添加失败");
        }
    }

    @Override
    @Transactional
    public void deleteSubject(int id) {
        List<Integer> idList = new ArrayList<Integer>();
        deleteSelfAndChildId(id, idList);
    }

    @Override
    public List<Subject> selectSubjectAll() {

        return null;
    }


    /**
     * 循环查询从顶级到所有子级课程分类,并封装成返回给页面的集合格式
     * @param i 默认为0,为查询的parent_id
     * @return 返回给页面的集合
     */
    @Transactional
    public List<SubjectVo> getSonSubjects(int i) {
        List<Subject> subjectList = mapper.getSonSubjects(i);
        if (subjectList != null) {
            List<SubjectVo> list = new ArrayList<SubjectVo>();
            for (Subject subject : subjectList) {
                SubjectVo subjectVo = new SubjectVo();
                subjectVo.setId(subject.getId());
                subjectVo.setTitle(subject.getTitle());
                subjectVo.setChildren(getSonSubjects(subject.getId()));
                if (subjectVo.getChildren().isEmpty()){
                    subjectVo.setChildren(null);
                }
                list.add(subjectVo);
            }
            return list;
        }
        return null;
    }

    /**
     * 删除本id-查找子级id(循环)
     *
     * @param id 父级id
     */

    public void deleteSelfAndChildId(int id, List<Integer> idList) {
        idList.add(id);
        int[] childIds = mapper.getChildID(id);
        if (childIds != null) {
            for (int childId : childIds) {
                deleteSelfAndChildId(childId, idList);
            }
        }
        mapper.deleteSubjects(idList);
    }
}



