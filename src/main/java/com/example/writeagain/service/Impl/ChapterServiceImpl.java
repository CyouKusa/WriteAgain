package com.example.writeagain.service.Impl;

import com.example.writeagain.javabean.Chapter;
import com.example.writeagain.mapper.ChapterMapper;
import com.example.writeagain.mapper.VideoMapper;
import com.example.writeagain.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.Date;
import java.util.List;

@Service
public class ChapterServiceImpl implements ChapterService {
    @Autowired
    private ChapterMapper mapper;
    @Autowired
    private VideoMapper videoMapper;

    @Override
    public List<Chapter> getChatpers(int courseId) {
        try {
            List<Chapter> chapterList = mapper.getChatpers(courseId);
            return chapterList;
        }catch (IndexOutOfBoundsException exception){
            return null;
        }

    }

    @Override
    public void addChapter(Chapter chapter) {
        Date date = new Date();
        chapter.setGmtCreated(date);
        chapter.setGmtModified(date);
        int i = mapper.addChapter(chapter);
        if (i < 1) {
            throw new RuntimeException("添加课程章节失败");
        }
    }

    @Transactional
    @Override
    public void deleteChapter(int chapterId,int courseId) {
        List<String> videoSourceIds = videoMapper.findVideoSourceIdsByChapterId(chapterId,courseId);
        if (!videoSourceIds.isEmpty()){
            for (String filePath:videoSourceIds) {
                String deletePath ="D:/nginx/pic"+filePath.substring(filePath.lastIndexOf("/",filePath.lastIndexOf("/")-1));
                File file = new File(deletePath);
                boolean delete = file.delete();
                if (!delete){
                    throw new RuntimeException("删除云端视频失败");
                }
            }
            int j = videoMapper.deleteVideoByChapterId(chapterId,courseId);
            if (j < 1) {
                throw new RuntimeException("删除小节失败");
            }
        }
        int i = mapper.deleteChapter(chapterId,courseId);
        if (i < 1) {
            throw new RuntimeException("删除章节失败");
        }
    }
}
