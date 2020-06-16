package com.xt.andrewx.entity;

public class UserInfo {
    private String id;
    private String username;
    private String phone_number;
    private String only_id;
    private String intro;
    private String birthday;

    private String head_avt;
    private String back_pic;

    private int countOfFollower;
    private int countOfFan;

    private int countOfArticle;
    private int countOfRecommned;
    private int countOfLike;
    private int countOfComment;
    private int countOfNotice;

    public UserInfo(String id,
                    String username,
                    String phone_number,
                    String only_id,
                    String intro,
                    String birthday,
                    String head_avt,
                    String back_pic,
                    int countOfFollower,
                    int countOfFan,
                    int countOfArticle,
                    int countOfRecommned,
                    int countOfLike,
                    int countOfComment,
                    int countOfNotice) {
        this.id = id;
        this.username = username;
        this.phone_number = phone_number;
        this.only_id = only_id;
        this.intro = intro;
        this.birthday = birthday;
        this.head_avt = head_avt;
        this.back_pic = back_pic;
        this.countOfFollower = countOfFollower;
        this.countOfFan = countOfFan;
        this.countOfArticle = countOfArticle;
        this.countOfRecommned = countOfRecommned;
        this.countOfLike = countOfLike;
        this.countOfComment = countOfComment;
        this.countOfNotice = countOfNotice;
    }

    public UserInfo(String id,
                    String username,
                    String phone_number,
                    String only_id,
                    String intro,
                    String birthday,
                    String head_avt,
                    String back_pic,
                    int countOfFollower,
                    int countOfFan) {
        this.id = id;
        this.username = username;
        this.phone_number = phone_number;
        this.only_id = only_id;
        this.intro = intro;
        this.birthday = birthday;
        this.head_avt = head_avt;
        this.back_pic = back_pic;
        this.countOfFollower = countOfFollower;
        this.countOfFan = countOfFan;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getOnly_id() {
        return only_id;
    }

    public void setOnly_id(String only_id) {
        this.only_id = only_id;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getHead_avt() {
        return head_avt;
    }

    public void setHead_avt(String head_avt) {
        this.head_avt = head_avt;
    }

    public String getBack_pic() {
        return back_pic;
    }

    public void setBack_pic(String back_pic) {
        this.back_pic = back_pic;
    }

    public User toUser(){
        User user = new User(id,username,"",phone_number);
        return user;
    }

    public int getCountOfFollower() {
        return countOfFollower;
    }

    public void setCountOfFollower(int countOfFollower) {
        this.countOfFollower = countOfFollower;
    }

    public int getCountOfFan() {
        return countOfFan;
    }

    public void setCountOfFan(int countOfFan) {
        this.countOfFan = countOfFan;
    }

    public int getCountOfArticle() {
        return countOfArticle;
    }

    public void setCountOfArticle(int countOfArticle) {
        this.countOfArticle = countOfArticle;
    }

    public int getCountOfRecommned() {
        return countOfRecommned;
    }

    public void setCountOfRecommned(int countOfRecommned) {
        this.countOfRecommned = countOfRecommned;
    }

    public int getCountOfLike() {
        return countOfLike;
    }

    public void setCountOfLike(int countOfLike) {
        this.countOfLike = countOfLike;
    }

    public int getCountOfComment() {
        return countOfComment;
    }

    public void setCountOfComment(int countOfComment) {
        this.countOfComment = countOfComment;
    }

    public int getCountOfNotice() {
        return countOfNotice;
    }

    public void setCountOfNotice(int countOfNotice) {
        this.countOfNotice = countOfNotice;
    }
}
