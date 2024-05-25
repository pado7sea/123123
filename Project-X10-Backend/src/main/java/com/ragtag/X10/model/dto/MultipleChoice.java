package com.ragtag.X10.model.dto;

public class MultipleChoice {
    private int multipleChoiceId;
    private int questionId;
    private String choiceContent;
    private boolean isAnswer;

    public MultipleChoice() {
    }

    public MultipleChoice(int multipleChoiceId, int questionId, String choiceContent, boolean isAnswer) {
        this.multipleChoiceId = multipleChoiceId;
        this.questionId = questionId;
        this.choiceContent = choiceContent;
        this.isAnswer = isAnswer;
    }

    public int getMultipleChoiceId() {
        return multipleChoiceId;
    }

    public void setMultipleChoiceId(int multipleChoiceId) {
        this.multipleChoiceId = multipleChoiceId;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getChoiceContent() {
        return choiceContent;
    }

    public void setChoiceContent(String choiceContent) {
        this.choiceContent = choiceContent;
    }

    public boolean isAnswer() {
        return isAnswer;
    }

    public void setAnswer(boolean isAnswer) {this.isAnswer = isAnswer;}

    @Override
    public String toString() {
        return "MultipleChoice{" +
                "multipleChoiceId=" + multipleChoiceId +
                ", questionId=" + questionId +
                ", choiceContent='" + choiceContent + '\'' +
                ", isAnswer=" + isAnswer +
                '}';
    }
}
