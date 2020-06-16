package com.xt.andrewx.entity;


import java.util.List;

public class Article {
    private String id;
    private String user_id;
    private String release_date;
    private String title;
    private String content;
    private int countOflike;
    private int countOfrecommend;
    private int countOfcollect;
    private int type;
    private List<String> urls;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getCountOflike() {
        return countOflike;
    }

    public void setCountOflike(int countOflike) {
        this.countOflike = countOflike;
    }

    public int getCountOfrecommend() {
        return countOfrecommend;
    }

    public void setCountOfrecommend(int countOfrecommend) {
        this.countOfrecommend = countOfrecommend;
    }

    public List<String> getUrls() {
        return urls;
    }

    public void setUrls(List<String> urls) {
        this.urls = urls;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCountOfcollect() {
        return countOfcollect;
    }

    public void setCountOfcollect(int countOfcollect) {
        this.countOfcollect = countOfcollect;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Article(String id, String user_id, String release_date,
                   String title, String content, int countOflike,
                   int countOfrecommend, int countOfcollect, int type) {
        this.id = id;
        this.user_id = user_id;
        this.release_date = release_date;
        this.title = title;
        this.content = content;
        this.countOflike = countOflike;
        this.countOfrecommend = countOfrecommend;
        this.countOfcollect = countOfcollect;
        this.type = type;
    }
}
