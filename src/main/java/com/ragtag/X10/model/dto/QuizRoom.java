package com.ragtag.X10.model.dto;

public class QuizRoom {
    private int quizRoomId;
    private int groupId;
    private String quizRoomTitle;
    private String quizRoomContent;
    private int WorkbookId;
    private int TimeLimit;
    private int Singly;
    private String Creator;
    private int MaxNum;
    private int isStarted;

    public QuizRoom() {
    }

    public QuizRoom(int quizRoomId, int groupId, String quizRoomTitle, String quizRoomContent, int workbookId, int timeLimit, int singly, String creator, int maxNum, int isStarted) {
        this.quizRoomId = quizRoomId;
        this.groupId = groupId;
        this.quizRoomTitle = quizRoomTitle;
        this.quizRoomContent = quizRoomContent;
        WorkbookId = workbookId;
        TimeLimit = timeLimit;
        Singly = singly;
        Creator = creator;
        MaxNum = maxNum;
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

    public String getQuizRoomContent() {
        return quizRoomContent;
    }

    public void setQuizRoomContent(String quizRoomContent) {
        this.quizRoomContent = quizRoomContent;
    }

    public int getWorkbookId() {
        return WorkbookId;
    }

    public void setWorkbookId(int workbookId) {
        WorkbookId = workbookId;
    }

    public int getTimeLimit() {
        return TimeLimit;
    }

    public void setTimeLimit(int timeLimit) {
        TimeLimit = timeLimit;
    }

    public int getSingly() {
        return Singly;
    }

    public void setSingly(int singly) {
        Singly = singly;
    }

    public String getCreator() {
        return Creator;
    }

    public void setCreator(String creator) {
        Creator = creator;
    }

    public int getMaxNum() {
        return MaxNum;
    }

    public void setMaxNum(int maxNum) {
        MaxNum = maxNum;
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
                ", quizRoomContent='" + quizRoomContent + '\'' +
                ", WorkbookId=" + WorkbookId +
                ", TimeLimit=" + TimeLimit +
                ", Singly=" + Singly +
                ", Creator='" + Creator + '\'' +
                ", MaxNum=" + MaxNum +
                ", isStarted=" + isStarted +
                '}';
    }
}
