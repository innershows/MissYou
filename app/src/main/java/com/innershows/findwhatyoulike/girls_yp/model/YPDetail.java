package com.innershows.findwhatyoulike.girls_yp.model;

import java.util.List;

/**
 * Created by innershows on 16/10/14.
 *
 * @author innershows
 * @date 16/10/14
 * @e_mail innershow@gmail.com
 */

public class YPDetail {
    private List<String> imgs;
    private String content;

    private List<String> comments;


    public List<String> getImgs() {
        return imgs;
    }

    public void setImgs(List<String> imgs) {
        this.imgs = imgs;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<String> getComments() {
        return comments;
    }

    @Override
    public String toString() {
        return "YPDetail{" +
                "imgs=" + imgs +
                ", content='" + content + '\'' +
                ", comments=" + comments +
                '}';
    }

    public void setComments(List<String> comments) {

        this.comments = comments;
    }
}
