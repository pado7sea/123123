package com.ragtag.X10.model.dto;

public class UserQuizRoom {
    private int userQuizRoomId;
    private String userId;
    private int quizRoomId;
    private String startTime;
    private int isReady;

    public UserQuizRoom() {
    }

    public UserQuizRoom(int userQuizRoomId, String userId, int quizRoomId, String startTime, int isReady) {
        this.userQuizRoomId = userQuizRoomId;
        this.userId = userId;
        this.quizRoomId = quizRoomId;
        this.startTime = startTime;
        this.isReady = isReady;
    }

    public int getUserQuizRoomId() {
        return userQuizRoomId;
    }

    public void setUserQuizRoomId(int userQuizRoomId) {
        this.userQuizRoomId = userQuizRoomId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getQuizRoomId() {
        return quizRoomId;
    }

    public void setQuizRoomId(int quizRoomId) {
        this.quizRoomId = quizRoomId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public int getIsReady() {
        return isReady;
    }

    public void setIsReady(int isReady) {
        this.isReady = isReady;
    }

    @Override
    public String toString() {
        return "UserQuizRoom{" +
                "userQuizRoomId=" + userQuizRoomId +
                ", userId='" + userId + '\'' +
                ", quizRoomId=" + quizRoomId +
                ", startTime='" + startTime + '\'' +
                ", isReady=" + isReady +
                '}';
    }
}
