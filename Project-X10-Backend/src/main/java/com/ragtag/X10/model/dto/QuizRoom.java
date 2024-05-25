package com.ragtag.X10.model.dto;

public class QuizRoom {
    private int quizRoomId;
    private int groupId;
    private String quizRoomTitle;
    private int quizRoomWorkbookId;
    private int quizRoomTimeLimit;
    private int quizRoomSingly;
    private String quizRoomCreator;
    private int quizRoomMaxNum;
    private int isStarted;

    public QuizRoom() {
    }

    public QuizRoom(int quizRoomId, int groupId, String quizRoomTitle, int quizRoomWorkbookId, int quizRoomTimeLimit, int quizRoomSingly, String quizRoomCreator, int quizRoomMaxNum, int isStarted) {
        this.quizRoomId = quizRoomId;
        this.groupId = groupId;
        this.quizRoomTitle = quizRoomTitle;
        this.quizRoomWorkbookId = quizRoomWorkbookId;
        this.quizRoomTimeLimit = quizRoomTimeLimit;
        this.quizRoomSingly = quizRoomSingly;
        this.quizRoomCreator = quizRoomCreator;
        this.quizRoomMaxNum = quizRoomMaxNum;
        this.isStarted = isStarted;
    }

    public int getQuizRoomId() {
        return quizRoomId;
    }

    public void setQuizRoomId(int quizRoomId) {
        this.quizRoomId = quizRoomId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getQuizRoomTitle() {
        return quizRoomTitle;
    }

    public void setQuizRoomTitle(String quizRoomTitle) {
        this.quizRoomTitle = quizRoomTitle;
    }

    public int getQuizRoomWorkbookId() {
        return quizRoomWorkbookId;
    }

    public void setQuizRoomWorkbookId(int quizRoomWorkbookId) {
        this.quizRoomWorkbookId = quizRoomWorkbookId;
    }

    public int getQuizRoomTimeLimit() {
        return quizRoomTimeLimit;
    }

    public void setQuizRoomTimeLimit(int quizRoomTimeLimit) {
        this.quizRoomTimeLimit = quizRoomTimeLimit;
    }

    public int getQuizRoomSingly() {
        return quizRoomSingly;
    }

    public void setQuizRoomSingly(int quizRoomSingly) {
        this.quizRoomSingly = quizRoomSingly;
    }

    public String getQuizRoomCreator() {
        return quizRoomCreator;
    }

    public void setQuizRoomCreator(String quizRoomCreator) {
        this.quizRoomCreator = quizRoomCreator;
    }

    public int getQuizRoomMaxNum() {
        return quizRoomMaxNum;
    }

    public void setQuizRoomMaxNum(int quizRoomMaxNum) {
        this.quizRoomMaxNum = quizRoomMaxNum;
    }

    public int getIsStarted() {
        return isStarted;
    }

    public void setIsStarted(int isStarted) {
        this.isStarted = isStarted;
    }

    @Override
    public String toString() {
        return "QuizRoom{" +
                "quizRoomId=" + quizRoomId +
                ", groupId=" + groupId +
                ", quizRoomTitle='" + quizRoomTitle + '\'' +
                ", quizRoomWorkbookId=" + quizRoomWorkbookId +
                ", quizRoomTimeLimit=" + quizRoomTimeLimit +
                ", quizRoomSingly=" + quizRoomSingly +
                ", quizRoomCreator='" + quizRoomCreator + '\'' +
                ", quizRoomMaxNum=" + quizRoomMaxNum +
                ", isStarted=" + isStarted +
                '}';
    }
}
