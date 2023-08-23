package com.example.writeagain.mapper;

import com.example.writeagain.javabean.video;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface VideoMapper {

    int addVideo(video video);

    List<String> findVideoSourceIdsByChapterId(@Param("chapterId") int chapterId,@Param("courseId") int courseId);

    int deleteVideoByChapterId(@Param("chapterId") int chapterId,@Param("courseId") int courseId);

    int deleteVideo(int id);

    video findVideoById(int id);

    int updateVideo(video video);

    void deleteVideoByCourseId(int id);
}
