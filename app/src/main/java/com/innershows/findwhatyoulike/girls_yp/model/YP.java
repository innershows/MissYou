package com.innershows.findwhatyoulike.girls_yp.model;

import java.io.Serializable;

/**
 * Created by innershows on 16/8/12.
 *
 * @author innershows
 * @date 16/8/12
 * @e_mail innershow@gmail.com
 */
public class YP implements Serializable {
    private String avatarUrl;
    private String group;
    private String userName;
    private String address;
    private String date;
    private String title;
    private String userDetailUrl;

    public String getContentDetailUrl() {
        return contentDetailUrl;
    }

    public void setContentDetailUrl(String contentDetailUrl) {
        this.contentDetailUrl = contentDetailUrl;
    }
    private String contentDetailUrl;


    public String getUserDetailUrl() {
        return userDetailUrl;
    }

    public void setUserDetailUrl(String userDetailUrl) {
        this.userDetailUrl = userDetailUrl;
    }


    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "YP{" +
                "avatarUrl='" + avatarUrl + '\'' +
                ", group='" + group + '\'' +
                ", userName='" + userName + '\'' +
                ", address='" + address + '\'' +
                ", date='" + date + '\'' +
                ", title='" + title + '\'' +
                ", userDetailUrl='" + userDetailUrl + '\'' +
                ", contentDetailUrl='" + contentDetailUrl + '\'' +
                '}';
    }
}
