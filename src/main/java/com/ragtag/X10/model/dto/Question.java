package com.ragtag.X10.model.dto;

import java.util.List;

public class Question {
    private int questionId;
    private int workbookId;
    private String questionQ;
    private String questionA;
    private int questionType;
    private String questionExplain;
    private int questionDifficulty;
    private String questionMaker;
    private boolean questionSave;
    private String questionImg;
    private List<MultipleChoice> multipleChoices;

    public Question() {
    }

    public Question(int questionId, int workbookId, String questionQ, String questionA, int questionType, String questionExplain, int questionDifficulty, String questionMaker, boolean questionSave, String questionImg, List<MultipleChoice> multipleChoices) {
        this.questionId = questionId;
        this.workbookId = workbookId;
        this.questionQ = questionQ;
        this.questionA = questionA;
        this.questionType = questionType;
        this.questionExplain = questionExplain;
        this.questionDifficulty = questionDifficulty;
        this.questionMaker = questionMaker;
        this.questionSave = questionSave;
        this.questionImg = questionImg;
        this.multipleChoices = multipleChoices;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getWorkbookId() {
        return workbookId;
    }

    public void setWorkbookId(int workbookId) {
        this.workbookId = workbookId;
    }

    public String getQuestionQ() {
        return questionQ;
    }

    public void setQuestionQ(String questionQ) {
        this.questionQ = questionQ;
    }

    public String getQuestionA() {
        return questionA;
    }

    public void setQuestionA(String questionA) {
        this.questionA = questionA;
    }

    public int getQuestionType() {
        return questionType;
    }

    public void setQuestionType(int questionType) {
        this.questionType = questionType;
    }

    public String getQuestionExplain() {
        return questionExplain;
    }

    public void setQuestionExplain(String questionExplain) {
        this.questionExplain = questionExplain;
    }

    public int getQuestionDifficulty() {
        return questionDifficulty;
    }

    public void setQuestionDifficulty(int questionDifficulty) {
        this.questionDifficulty = questionDifficulty;
    }

    public String getQuestionMaker() {
        return questionMaker;
    }

    public void setQuestionMaker(String questionMaker) {
        this.questionMaker = questionMaker;
    }

    public boolean isQuestionSave() {
        return questionSave;
    }

    public void setQuestionSave(boolean questionSave) {
        this.questionSave = questionSave;
    }

    public String getQuestionImg() {
        return questionImg;
    }

    public void setQuestionImg(String questionImg) {
        this.questionImg = questionImg;
    }

    public List<MultipleChoice> getMultipleChoices() {
        return multipleChoices;
    }

    public void setMultipleChoices(List<MultipleChoice> multipleChoices) {
        this.multipleChoices = multipleChoices;
    }

    @Override
    public String toString() {
        return "Question{" +
                "questionId=" + questionId +
                ", workbookId=" + workbookId +
                ", questionQ='" + questionQ + '\'' +
                ", questionA='" + questionA + '\'' +
                ", questionType=" + questionType +
                ", questionExplain='" + questionExplain + '\'' +
                ", questionDifficulty=" + questionDifficulty +
                ", questionMaker='" + questionMaker + '\'' +
                ", questionSave=" + questionSave +
                ", questionImg='" + questionImg + '\'' +
                ", multipleChoices=" + multipleChoices +
                '}';
    }
}
