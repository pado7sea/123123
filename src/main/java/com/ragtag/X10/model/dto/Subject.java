package com.ragtag.X10.model.dto;

public class Subject {
    private int subjectId;
    private int groupId;
    private String subjectTitle;
    private String subjectContent;

    public Subject() {
    }

    public Subject(int subjectId, int groupId, String subjectTitle, String subjectContent) {
        this.subjectId = subjectId;
        this.groupId = groupId;
        this.subjectTitle = subjectTitle;
        this.subjectContent = subjectContent;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getSubjectTitle() {
        return subjectTitle;
    }

    public void setSubjectTitle(String subjectTitle) {
        this.subjectTitle = subjectTitle;
    }

    public String getSubjectContent() {
        return subjectContent;
    }

    public void setSubjectContent(String subjectContent) {
        this.subjectContent = subjectContent;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subjectId=" + subjectId +
                ", groupId=" + groupId +
                ", subjectTitle='" + subjectTitle + '\'' +
                ", subjectContent='" + subjectContent + '\'' +
                '}';
    }
}
