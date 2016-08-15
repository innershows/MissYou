package com.innershows.findwhatyoulike.girls_pictures.model;

import java.io.Serializable;

/**
 * Created by Zj on 2015/12/28.
 */
public class ImageFuli implements Serializable {

    private String title;

    public ImageFuli(String url) {
        this.url = url;
    }

    public ImageFuli() {
    }

    private String url;

    private int type;  // 0 表示gank，1表示豆瓣

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "ImageFuli{" +
                "type=" + type +
                ", url='" + url + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
