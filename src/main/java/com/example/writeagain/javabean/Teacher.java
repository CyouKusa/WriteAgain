package com.example.writeagain.javabean;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.Date;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Teacher {
    private int id;
    @NotBlank(message = "教师姓名不能为空")
    private String name;
    @Min(value = 1,message = "讲师级别只能是资深讲师或高级讲师")
    @Max(value = 2,message = "讲师级别只能是资深讲师或高级讲师")
    private int level;
    @NotBlank(message = "教师资历不能为空")
    private String career;
    @NotBlank(message = "教师简介不能为空")
    private String intro;
    @NotBlank(message = "教师头像不能为空")
    private String avatar;
    private boolean isDetele;
    private Date gmtCreated;
    private Date gmtModified;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public String getCareer() {
        return career;
    }
    public void setCareer(String career) {
        this.career = career;
    }
    public String getIntro() {
        return intro;
    }
    public void setIntro(String intro) {
        this.intro = intro;
    }
    public String getAvatar() {
        return avatar;
    }
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
    public boolean getIsDetele() {
        return isDetele;
    }
    public void setIsDetele(boolean isDetele) {
        this.isDetele = isDetele;
    }
    public Date getGmtCreated() {
        return gmtCreated;
    }
    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }
    public Date getGmtModified() {
        return gmtModified;
    }
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }
    @Override
    public String toString() {
        return "Teacher [id=" + id + ", name=" + name + ", level=" + level + ", career=" + career + ", intro=" + intro
                + ", avatar=" + avatar + ", isDetele=" + isDetele + ", gmtCreated=" + gmtCreated + ", gmtModified="
                + gmtModified + "]";
    }
}
