package com.ragtag.X10.model.dto;

public class UserQuestionRecord {

    private int questionId;
    private String userId;
    private boolean isCorrect;
    private String recordTime;

    public UserQuestionRecord() {
    }

    public UserQuestionRecord(int questionId, String userId, boolean isCorrect, String recordTime) {
        this.questionId = questionId;
        this.userId = userId;
        this.isCorrect = isCorrect;
        this.recordTime = recordTime;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    public String getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(String recordTime) {
        this.recordTime = recordTime;
    }

    @Override
    public String toString() {
        return "UserQuestionRecord{" +
                "questionId=" + questionId +
                ", userId='" + userId + '\'' +
                ", isCorrect=" + isCorrect +
                ", recordTime='" + recordTime + '\'' +
                '}';
    }
}
