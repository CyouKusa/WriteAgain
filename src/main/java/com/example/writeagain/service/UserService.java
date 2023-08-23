package com.example.writeagain.service;

import com.example.writeagain.javabean.User;

public interface UserService {
    public void register(User user);

    void deleteUser(Integer id);

    User login(User user);

    /**
     * 根据输入的email查询是否有账号,没有返回500,有返回200
     * @param email 要查询的邮箱
     */
    void confirmEmail(String email);

    /**
     * 生成随机验证码,并和邮箱一起放入验证码SQL库,方便后面查询.再根据邮箱发送验证码
     * @param email 保存和发送的邮箱地址
     */
    void getCAPTCHA(String email);

    /**
     * 对比页面传来的验证码,通过则根据邮箱查找id修改密码
     * @param user1 用户对象,里面有邮箱和密码
     * @param captcha1 用户输入的验证码
     */
    void upload(User user1, String captcha1);
}
