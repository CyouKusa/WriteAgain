package com.example.writeagain.javabean;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SubjectFromNetwork {
    private String 课程分类名;
    private  String 课程分类所属;

    public String get课程分类名() {
        return 课程分类名;
    }

    public void set课程分类名(String 课程分类名) {
        this.课程分类名 = 课程分类名;
    }

    public String get课程分类所属() {
        return 课程分类所属;
    }

    public void set课程分类所属(String 课程分类所属) {
        this.课程分类所属 = 课程分类所属;
    }

    @Override
    public String toString() {
        return "SubjectFromNetwork{" +
                "课程分类名='" + 课程分类名 + '\'' +
                ", 课程分类所属='" + 课程分类所属 + '\'' +
                '}';
    }
}
