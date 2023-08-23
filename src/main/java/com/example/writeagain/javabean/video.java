package com.example.writeagain.javabean;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class video {
    private Integer id;
    @Min(value = 0,message = "课程id有误")
    private Integer courseId;
    @Min(value = 0,message = "章节id有误")
    private Integer chapterId;
    @NotBlank(message = "课程名不能为空")
    private String title;
    @NotBlank(message = "课程路径有误")
    private String videoSourceId;
    @NotBlank(message = "课程视频名有误")
    private String videoOriginalName;
    private Long playCount;
    private boolean free;
    @Min(value = 0,message = "视频时长有误")
    private Integer duration;
    private VideoStatus status;
    @Min(value = 0,message = "视频大小有误")
    private Long size;
    private Date gmtCreated;
    private Date gmtModified;
    private Chapter chapter;

    public boolean isFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }

    public Chapter getChapter() {
        return chapter;
    }

    public void setChapter(Chapter chapter) {
        this.chapter = chapter;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getChapterId() {
        return chapterId;
    }

    public void setChapterId(Integer chapterId) {
        this.chapterId = chapterId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVideoSourceId() {
        return videoSourceId;
    }

    public void setVideoSourceId(String videoSourceId) {
        this.videoSourceId = videoSourceId;
    }

    public String getVideoOriginalName() {
        return videoOriginalName;
    }

    public void setVideoOriginalName(String videoOriginalName) {
        this.videoOriginalName = videoOriginalName;
    }

    public Long getPlayCount() {
        return playCount;
    }

    public void setPlayCount(Long playCount) {
        this.playCount = playCount;
    }


    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public VideoStatus getStatus() {
        return status;
    }

    public void setStatus(VideoStatus status) {
        this.status = status;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public Date getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    @Override
    public String toString() {
        return "video{" +
                "id=" + id +
                ", courseId=" + courseId +
                ", chapterId=" + chapterId +
                ", title='" + title + '\'' +
                ", video_sourceId='" + videoSourceId + '\'' +
                ", videoOriginalName='" + videoOriginalName + '\'' +
                ", playCount=" + playCount +
                ", isFree=" + free +
                ", duration=" + duration +
                ", status=" + status +
                ", size=" + size +
                ", gmtCreated=" + gmtCreated +
                ", gmtModified=" + gmtModified +
                '}';
    }
}
