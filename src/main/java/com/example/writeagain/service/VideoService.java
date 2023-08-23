package com.example.writeagain.service;

import com.example.writeagain.javabean.video;

public interface VideoService {
    void addVideo(video video);

    void deleteVideo(int id);

    void deleteUploadVideo(String videoSourceId);

    video findVideoById(int id);

    void updateVideo(video video);
}
