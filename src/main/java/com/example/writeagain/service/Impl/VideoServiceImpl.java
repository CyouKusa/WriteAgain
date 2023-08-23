package com.example.writeagain.service.Impl;

import com.example.writeagain.javabean.VideoStatus;
import com.example.writeagain.javabean.video;
import com.example.writeagain.mapper.VideoMapper;
import com.example.writeagain.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Date;
@Service
public class VideoServiceImpl implements VideoService {
    @Autowired
    private VideoMapper mapper;
    @Override
    public void addVideo(video video) {
        Date date = new Date();
        video.setGmtCreated(date);
        video.setGmtModified(date);
        video.setStatus(VideoStatus.Normal);
        int i = mapper.addVideo(video);
        if (i<1){
            throw new RuntimeException("添加小节失败");
        }
    }

    @Override
    public void deleteVideo(int id) {
        int i = mapper.deleteVideo(id);
        if (i<1){
            throw  new RuntimeException("删除小节失败");
        }
    }

    @Override
    public void deleteUploadVideo(String videoSourceId) {
        String fileName = videoSourceId.substring(videoSourceId.lastIndexOf("/",videoSourceId.lastIndexOf("/")-1)+1);
        String path = "D:/nginx/pic/"+fileName;
        boolean delete = new File(path).delete();
        if (!delete){
            throw new RuntimeException("删除视频文件缓存失败");
        }
    }

    @Override
    public video findVideoById(int id) {
        video video = mapper.findVideoById(id);
        return video;
    }

    @Override
    public void updateVideo(video video) {
        video.setGmtModified(new Date());
        int i = mapper.updateVideo(video);
        if (i<1){
            throw  new RuntimeException("修改小节失败");
        }
    }
}
