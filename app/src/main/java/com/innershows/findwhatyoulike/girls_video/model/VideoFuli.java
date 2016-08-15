package com.innershows.findwhatyoulike.girls_video.model;

import android.net.Uri;
import android.text.TextUtils;

import java.io.Serializable;

/**
 * Created by innershows on 16/8/11.
 *
 * @author innershows
 * @date 16/8/11
 * @e_mail innershow@gmail.com
 */
public class VideoFuli implements Serializable {
    private String title;
    private String imageUrl;
    private String author;
    private String linkUrl;
    private String avatarUrl;
    private boolean isLoading;

    public boolean isLoading() {
        return isLoading;
    }

    public void setLoading(boolean loading) {
        isLoading = loading;
    }

    public String getLinkUrl() {
        if (TextUtils.isEmpty(linkUrl)) {
            return "";
        }
        return Uri.parse(linkUrl).getLastPathSegment();
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    private String videoUrl;


    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    @Override
    public String toString() {
        return "VideoFuli{" +
                "title='" + title + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", author='" + author + '\'' +
                ", linkUrl='" + linkUrl + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", videoUrl='" + videoUrl + '\'' +
                '}';
    }
}
