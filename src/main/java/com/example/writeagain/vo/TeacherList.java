package com.example.writeagain.vo;

import com.example.writeagain.javabean.Teacher;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class TeacherList {
    private int total;
    private List<Teacher> list;
    private int pagesize;

    public int getPagesize() {
        return pagesize;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<Teacher> getList() {
        return list;
    }

    public void setList(List<Teacher> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "TeacherList{" +
                "total=" + total +
                ", list=" + list +
                ", pagesize=" + pagesize +
                '}';
    }
}
