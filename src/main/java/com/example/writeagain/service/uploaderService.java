package com.example.writeagain.service;

import com.example.writeagain.javabean.Subject;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

public interface uploaderService {
    /**
     * 将传入的图片文件重命名为UUID并放到对应的图床位置
     *
     * @param file 传入的图片
     * @return 存放完成的图片路径, 用于保存到SQL以及返回给页面显示
     */
    String uploadAvatar(MultipartFile file);

    void uploadExcel(MultipartFile file);

    int addSubject(Subject subject);

    int addSubjects(List<Subject> list);

    String uploadAvatar(File dfile);
}
