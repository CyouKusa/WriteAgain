package com.example.writeagain.javabean;

import com.example.writeagain.exception.ValidationGroups;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Date;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {
    private int id;
    @NotBlank(message = "账号不能为空")
    private String username;
    @NotBlank(message = "密码不能为空")
    private String passWord;
    @NotBlank(message = "昵称不能为空")
    private String nickName;
    @NotBlank(message = "请上传图片")
    private String avatar;
    @NotBlank(message = "请填写邮箱")
    @Email(message = "邮箱格式错误,请重新输入")
    @NotBlank(message = "请填写邮箱",groups = {ValidationGroups.onlyemail.class})
    @Email(message = "邮箱格式错误,请重新输入",groups = {ValidationGroups.onlyemail.class})
    private String email;
    private Date gmtCreated;
    private Date gmtModified;
    private boolean isDelete;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(boolean delete) {
        isDelete = delete;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", pass_word='" + passWord + '\'' +
                ", nickName='" + nickName + '\'' +
                ", avatar='" + avatar + '\'' +
                ", email='" + email + '\'' +
                ", gmtCreated=" + gmtCreated +
                ", gmtModified=" + gmtModified +
                ", isDelete=" + isDelete +
                '}';
    }
}
