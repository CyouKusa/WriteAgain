package com.example.writeagain.mapper;

import com.example.writeagain.javabean.Teacher;
import com.example.writeagain.vo.Condition;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TeacherMapper {
    /**
     * 添加讲师
     * @param teacher 讲师对象
     * @return /
     */
    int addTeacher(Teacher teacher);

    /**
     * 多条件分页查询讲师集合
     * @param i 开始查询下标
     * @param pagesize 每页显示条数
     * @param condition 查询条件
     * @return 查询到的讲师集合
     */
    List<Teacher> showTeacherByPage(@Param("index") int i,@Param("pagesize") int pagesize,@Param("condition") Condition condition);

    /**
     * 多条件查询总条数
     * @param condition 查询条件
     * @return  总条数
     */
    int getTeacherListTotal(Condition condition);

    /**
     * 根据讲师id删除讲师
     * @param id 要删除的讲师ID
     * @return 小于1代表修改失败,大于等于1代表修改成功
     */
    int deleteTeacher(Integer id);

    Teacher findTeacherById(Integer id);

    /**
     * 修改讲师信息
     * @param teacher 要写入的修改后的讲师信息
     * @return 小于1代表修改失败,大于等于1代表修改成功
     */
    int updateTeacher(Teacher teacher);

    /**
     * 根据id数组批量删除讲师
     * @param ids 要删除的id数组
     * @return 小于1代表修改失败,大于等于1代表修改成功
     */
    int deleteSelected(int[] ids);

    List<Teacher> selectTeacherAll();
}
