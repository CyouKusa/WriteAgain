package com.example.writeagain.service.Impl;

import com.example.writeagain.javabean.Teacher;
import com.example.writeagain.mapper.TeacherMapper;
import com.example.writeagain.service.TeacherService;
import com.example.writeagain.vo.Condition;
import com.example.writeagain.vo.Constant;
import com.example.writeagain.vo.TeacherList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service

public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherMapper mapper;

    @Override
    public void addTeacher(Teacher teacher) {
        teacher.setIsDetele(true);
        teacher.setGmtCreated(new Date());
        teacher.setGmtModified(new Date());
        int i = mapper.addTeacher(teacher);
        if (i < 1) {
            throw new RuntimeException("添加讲师失败");
        }
    }

    @Override
    public TeacherList showTeacherByPage(int currentPage, Condition condition) {
        List<Teacher> list = mapper.showTeacherByPage((currentPage - 1) * Constant.PAGESIZE, Constant.PAGESIZE, condition);
        int total = mapper.getTeacherListTotal(condition);
        TeacherList teacherList = new TeacherList();
        teacherList.setList(list);
        teacherList.setTotal(total);
        teacherList.setPagesize(Constant.PAGESIZE);
        return teacherList;
    }

    @Override
    public void deleteTeacher(Integer id) {
        int i = mapper.deleteTeacher(id);
        if (i < 1) {
            throw new RuntimeException("删除讲师失败");
        }
    }

    @Override
    public Teacher findTeacherById(Integer id) {
        Teacher teacher = mapper.findTeacherById(id);
        if (teacher == null) {
            throw new RuntimeException("查询讲师失败");
        }
        return teacher;
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        teacher.setGmtModified(new Date());
        int i = mapper.updateTeacher(teacher);
        if (i < 1) {
            throw new RuntimeException("修改失败");
        }
    }

    @Override
    public void deleteSelected(int[] ids) {
        int i = mapper.deleteSelected(ids);
        if (i < 1) {
            throw new RuntimeException("删除全部失败");
        } else if (i != ids.length) {
            throw new RuntimeException("删除部分成功");
        }
    }

    @Override
    public List<Teacher> selectTeacherAll() {
        List<Teacher> list = mapper.selectTeacherAll();
        return list;
    }
}
