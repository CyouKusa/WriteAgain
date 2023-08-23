package com.example.writeagain.mapper;

import com.example.writeagain.javabean.Chapter;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ChapterMapper {

    List<Chapter> getChatpers(int courseId);

    int addChapter(Chapter chapter);

    int deleteChapter(@Param("chapterId") int chapterId, @Param("courseId") int courseId);

    void deleteChapterByCourseId(int id);
}
