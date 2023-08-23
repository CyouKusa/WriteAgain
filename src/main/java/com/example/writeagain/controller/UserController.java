package com.example.writeagain.controller;

import com.example.writeagain.exception.ValidationGroups;
import com.example.writeagain.javabean.User;
import com.example.writeagain.service.UserService;
import com.example.writeagain.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.Map;

@RestController
@CrossOrigin
@Validated
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService service;

    @RequestMapping("/register")
    public Result register(@RequestBody @Valid User user){
        service.register(user);
        return Result.ok(null);
    }

    @RequestMapping("/deleteUser/{id}")
    public Result deleteUser(@Valid @PathVariable Integer id){
        service.deleteUser(id);
        return Result.ok(null);
    }

    @RequestMapping("/login")
    public Result login(@RequestBody User user){
        User login = service.login(user);
        return Result.ok(login);
    }
    @RequestMapping("/send/{name}")
    public Result send(@PathVariable String name){
        return Result.ok(name);
    }

    @RequestMapping("/confirmEmail")
    public Result confirmEmail(@Validated(ValidationGroups.onlyemail.class) @RequestBody User user){
       service.confirmEmail(user.getEmail());
        return Result.ok(null);
    }

    @RequestMapping("/getCAPTCHA/{email}")
    public Result getCAPTCHA(@PathVariable String email){
        service.getCAPTCHA(email);
        return Result.ok(null);
    }
    @RequestMapping("/upload")
    public Result upload(String email,@NotBlank(message = "密码不能为空") String passWord,@NotBlank(message = "验证码不能为空") String CAPTCHA){
        User user = new User();
        user.setPassWord(passWord);
        user.setEmail(email);
        service.upload(user,CAPTCHA);
        return Result.ok(null);
    }
}
