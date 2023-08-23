package com.example.writeagain.vo;

import java.util.ArrayList;
import java.util.List;

public class SubjectVo {
    private int id;
    private String title;
    private List<SubjectVo> children;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<SubjectVo> getChildren() {
        return children;
    }

    public void setChildren(List<SubjectVo> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "SubjectVo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", children=" + children +
                '}';
    }
}
