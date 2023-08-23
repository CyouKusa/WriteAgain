package com.example.writeagain.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.PageReadListener;
import com.example.writeagain.javabean.Subject;
import com.example.writeagain.javabean.SubjectFromNetwork;
import com.example.writeagain.javabean.video;
import com.example.writeagain.service.uploaderService;
import com.example.writeagain.utils.DataListener;
import com.example.writeagain.vo.Result;
import it.sauronsoftware.jave.EncoderException;
import it.sauronsoftware.jave.MultimediaInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import it.sauronsoftware.jave.Encoder;
import java.io.File;
import java.io.IOException;

/**
 * 用以接收网页上传的图片类,只做网页上传图片到图床的连接,不操作SQL
 */

@RestController
@CrossOrigin
@RequestMapping("/uploader")
public class UploadController {
    @Autowired
    private uploaderService service;


    @RequestMapping("/avatar")
        public Result uploadAvatar(MultipartFile file) {
            String avatarRoute = service.uploadAvatar(file);
            return Result.ok(avatarRoute);
    }

    @RequestMapping("/excel")
    public Result uploadExcel(MultipartFile file) {
        service.uploadExcel(file);
        return Result.ok(null);
    }

    @RequestMapping("/video")
    public Result uploadVideo(MultipartFile file) {
        String extension = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")+1).toLowerCase();
        if(extension.equals("mp4") && extension.equals("mov")){
            throw new RuntimeException("文件格式不符");
        };
        if (file.getSize()>209715200){
            throw new RuntimeException("文件大小过大");
        };
        String name = file.getOriginalFilename();
        File dfile = null;
        try {
            dfile = File.createTempFile("prefix", "_" + file.getOriginalFilename());
            file.transferTo(dfile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 获取视频时长
        Encoder encoder = new Encoder();
        MultimediaInfo m = null;
        try {
            m = encoder.getInfo(dfile);
        } catch (EncoderException e) {
            throw new RuntimeException(e);
        }
        long ls = m.getDuration();
        String url = service.uploadAvatar(dfile);
        video video = new video();
        video.setVideoOriginalName(name);
        video.setVideoSourceId(url);
        video.setSize((file.getSize() / 1024));
        video.setDuration((int) ls/1000);
        //删除临时文件
        dfile.delete();
        return Result.ok(video);
    }


    @PostMapping("upload")
    @ResponseBody
    public void upload(MultipartFile file) throws IOException {
        EasyExcel.read(file.getInputStream(), SubjectFromNetwork.class, new PageReadListener<SubjectFromNetwork>(dataList -> {
            System.out.println(dataList);
        })).sheet().doRead();
    }
}
