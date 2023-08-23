package com.example.writeagain.service;

import com.example.writeagain.javabean.Teacher;
import com.example.writeagain.vo.Condition;
import com.example.writeagain.vo.TeacherList;

import java.util.List;

public interface TeacherService {
    /**
     * 添加讲师 补充数据
     * @param teacher 页面传来的讲师信息
     */
    void addTeacher(Teacher teacher);

    /**
     * 多条件分页查询讲师
     * @param currentPage 当前页码
     * @param condition 多条件
     * @return  查询到的讲师集合
     */
    TeacherList showTeacherByPage(int currentPage, Condition condition);

    /**
     * 根据讲师id删除讲师
     * @param id 要删除的讲师id
     */
    void deleteTeacher(Integer id);

    /**
     * 根据讲师id查询讲师信息
     * @param id 要查询的讲师id
     * @return 查询到的讲师信息
     */
    Teacher findTeacherById(Integer id);

    /**
     * 修改讲师信息
     * @param teacher 修改后的讲师对象
     */
    void updateTeacher(Teacher teacher);

    /**
     * 根据id数组批量删除讲师
     * @param ids 要删除的id数组
     */
    void deleteSelected(int[] ids);

    /**
     * 查询所有教师,返回id和姓名
     * @return 只有id和姓名的对象
     */
    List<Teacher> selectTeacherAll();
}
