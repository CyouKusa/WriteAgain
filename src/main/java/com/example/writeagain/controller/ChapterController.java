package com.example.writeagain.controller;

import com.example.writeagain.javabean.Chapter;
import com.example.writeagain.service.ChapterService;
import com.example.writeagain.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/Chapter")
public class ChapterController {
    @Autowired
    private ChapterService service;

    @RequestMapping("/getChatpers/{courseId}")
    public Result getChatpers(@PathVariable int courseId) {
        List<Chapter> chapterList = service.getChatpers(courseId);
        return Result.ok(chapterList);
    }

    @RequestMapping("/addChapter")
    public Result addChapter(@RequestBody Chapter chapter){
        service.addChapter(chapter);
        return Result.ok(null);
    }

    @RequestMapping("/deleteChapter/{chapterId}/{courseId}")
    public Result deleteChapter(@PathVariable int chapterId,@PathVariable int courseId){
        service.deleteChapter(chapterId,courseId);
        return Result.ok(null);
    }
}
