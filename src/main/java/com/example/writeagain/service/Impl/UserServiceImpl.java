package com.example.writeagain.service.Impl;

import com.example.writeagain.exception.ValidationGroups;
import com.example.writeagain.javabean.User;
import com.example.writeagain.mapper.UserMapper;
import com.example.writeagain.service.UserService;
import com.example.writeagain.utils.MD5Utils;
import com.example.writeagain.utils.sendMail;
import com.example.writeagain.vo.Result;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.mail.MessagingException;
import javax.validation.constraints.NotBlank;
import java.sql.Date;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper mapper;
    private Result result;
    @Override
    public void register(User user) {
        String s = MD5Utils.string2MD5(user.getPassWord());
        user.setPassWord(s);
        user.setIsDelete(true);
        user.setGmtCreated(new Date(new java.util.Date().getTime()));
        user.setGmtModified(new Date(new java.util.Date().getTime()));
        int i = mapper.addUser(user);
        if (i<1){
            throw new RuntimeException("注册失败");
        }
    }

    @Override
    public void deleteUser(Integer id) {
        if (id==null){
            throw new RuntimeException("请重新确定要删除的用户");
        }
        int i = mapper.deleteUser(id);
        if (i<1){
            throw new RuntimeException("未找到该用户,删除失败");
        }
    }

    @Override
    public User login(User user) {
        if (StringUtils.isBlank(user.getUsername())){//注意是Apache包
            throw new RuntimeException("请输入用户名");
        }
        if (StringUtils.isBlank(user.getUsername())){
            throw new RuntimeException("请输入密码");
        }
        String s = MD5Utils.string2MD5(user.getPassWord());
        User u = mapper.getUserByUserName(user.getUsername());
        if (u==null){
            throw new RuntimeException("账号有误");
        }
        if (!u.getPassWord().equals(s)){
            throw new RuntimeException("密码错误");
        }
        u.setPassWord(null);
        return u;
    }

    @Override
    public void confirmEmail(String email) {
        User user =  mapper.confirmEmail(email);
        if (user==null){
            throw new RuntimeException("未查找到此邮箱");
        }
    }

    @Override
    public void getCAPTCHA(String email) {
        int CAPTCHA = (int) (Math.random() * 1000000);
        Integer isCAPTCHA = mapper.getCaptchaByEmail(email);
        if (isCAPTCHA==null){
            mapper.setCAPTCHA(email,CAPTCHA,new java.util.Date());
        }else{
            mapper.updateCAPTCHA(email,CAPTCHA,new java.util.Date());
        }
        try {
            new sendMail().sendEmail(email,"您的验证码为"+CAPTCHA+",请在5分钟之内使用. 过期作废");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void upload(User user1,String captcha1) {
        java.util.Date date = mapper.getGmtCreatedByEmail(user1.getEmail());
        long l = new java.util.Date().getTime() - date.getTime();
        if (l>300000){
            throw new RuntimeException("验证码超时,请重新接收");
        }
        String captcha = String.valueOf(mapper.getCaptchaByEmail(user1.getEmail()));
        if (!captcha.equals(captcha1)){
            throw new RuntimeException("验证码错误,请重新输入");
        }
        user1.setPassWord(MD5Utils.string2MD5(user1.getPassWord()));//加密密码
        mapper.uploadPassWord(user1);
    }
}
