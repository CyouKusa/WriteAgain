package com.example.writeagain.mapper;

import com.example.writeagain.javabean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

@Mapper
public interface UserMapper {
    public int addUser(User user);

    int deleteUser(Integer id);

    User login(User user);

    User getUserByUserName(String username);

    User confirmEmail(String email);

    void setCAPTCHA(@Param("email") String email, @Param("CAPTCHA") int CAPTCHA, @Param("date") Date date);

    Integer getCaptchaByEmail(String email);

    Date getGmtCreatedByEmail(String email);

    void uploadPassWord(User user1);

    void updateCAPTCHA(@Param("email") String email, @Param("captcha") int captcha,@Param("date")  Date date);
}
