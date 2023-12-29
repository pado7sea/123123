package com.ragtag.X10.model.dto;

public class User {
    private String userId;
    private String userPassword;
    private String userName;
    private String userNickname;
    private String userEmail;
    private String userImg;
    private int userSolvedQuestion;
    private int userLevel;
    private boolean isOnline;
    private boolean isReady;

    public User() {
    }

    public User(String userId, String userPassword, String userName, String userNickname, String userEmail, String userImg, int userSolvedQuestion, int userLevel, boolean isOnline, boolean isReady) {
        this.userId = userId;
        this.userPassword = userPassword;
        this.userName = userName;
        this.userNickname = userNickname;
        this.userEmail = userEmail;
        this.userImg = userImg;
        this.userSolvedQuestion = userSolvedQuestion;
        this.userLevel = userLevel;
        this.isOnline = isOnline;
        this.isReady = isReady;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    public int getUserSolvedQuestion() {
        return userSolvedQuestion;
    }

    public void setUserSolvedQuestion(int userSolvedQuestion) {
        this.userSolvedQuestion = userSolvedQuestion;
    }

    public int getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(int userLevel) {
        this.userLevel = userLevel;
    }

    public boolean getIsOnline() {
        return isOnline;
    }

    public void setIsOnline(boolean isOnline) {
        isOnline = isOnline;
    }

    public boolean getIsReady() {
        return isReady;
    }

    public void setIsReady(boolean isReady) {
        this.isReady = isReady;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userName='" + userName + '\'' +
                ", userNickname='" + userNickname + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userImg='" + userImg + '\'' +
                ", userSolvedQuestion=" + userSolvedQuestion +
                ", userLevel=" + userLevel +
                ", isOnline=" + isOnline +
                ", isReady=" + isReady +
                '}';
    }
}
