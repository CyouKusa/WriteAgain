package com.example.writeagain.controller;

import com.example.writeagain.javabean.video;
import com.example.writeagain.service.ChapterService;
import com.example.writeagain.service.VideoService;
import com.example.writeagain.vo.Result;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@CrossOrigin
@RequestMapping("/video")
public class VideoController {
    @Autowired
    private VideoService service;

    @RequestMapping("/addVideo")
    public Result addVideo(@Valid @RequestBody video video) {
        service.addVideo(video);
        return Result.ok(null);
    }

    @RequestMapping("/deleteVideo/{id}")
    public Result deleteVideo(@PathVariable int id) {
        service.deleteVideo(id);
        return Result.ok(null);
    }

    @RequestMapping("/deleteUploadVideo")
    public Result deleteUploadVideo(@RequestBody String videoSourceId) {
        service.deleteUploadVideo(videoSourceId);
        return Result.ok(null);
    }

    @RequestMapping("/findVideoById/{id}")
    public Result findVideoById(@PathVariable int id) {
        video video = service.findVideoById(id);
        return Result.ok(video);
    }

    @RequestMapping("/updateVideo")
    public Result updateVideo(@RequestBody video video) {
        service.updateVideo(video);
        return Result.ok(null);
    }
}
