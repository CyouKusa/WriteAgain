package com.example.writeagain.service;

import com.example.writeagain.javabean.Chapter;

import java.util.List;

public interface ChapterService {
    List<Chapter> getChatpers(int courseId);

    void addChapter(Chapter chapter);

    void deleteChapter(int chapterId,int courseId);
}
