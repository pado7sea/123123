package com.ragtag.X10.model.dto;

public class Workbook {
    private int workbookId;
    private int subjectId;
    private String workbookTitle;
    private String workbookDetail;
    private String workbookDate;
    private String workbookDeadline;
    private int workbookQuota;

    public Workbook() {
    }

    public Workbook(int workbookId, int subjectId, String workbookTitle, String workbookDetail, String workbookDate, String workbookDeadline, int workbookQuota) {
        this.workbookId = workbookId;
        this.subjectId = subjectId;
        this.workbookTitle = workbookTitle;
        this.workbookDetail = workbookDetail;
        this.workbookDate = workbookDate;
        this.workbookDeadline = workbookDeadline;
        this.workbookQuota = workbookQuota;
    }

    public int getWorkbookId() {
        return workbookId;
    }

    public void setWorkbookId(int workbookId) {
        this.workbookId = workbookId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public String getWorkbookTitle() {
        return workbookTitle;
    }

    public void setWorkbookTitle(String workbookTitle) {
        this.workbookTitle = workbookTitle;
    }

    public String getWorkbookDetail() {
        return workbookDetail;
    }

    public void setWorkbookDetail(String workbookDetail) {
        this.workbookDetail = workbookDetail;
    }

    public String getWorkbookDate() {
        return workbookDate;
    }

    public void setWorkbookDate(String workbookDate) {
        this.workbookDate = workbookDate;
    }

    public String getWorkbookDeadline() {
        return workbookDeadline;
    }

    public void setWorkbookDeadline(String workbookDeadline) {
        this.workbookDeadline = workbookDeadline;
    }

    public int getWorkbookQuota() {
        return workbookQuota;
    }

    public void setWorkbookQuota(int workbookQuota) {
        this.workbookQuota = workbookQuota;
    }

    @Override
    public String toString() {
        return "Workbook{" +
                "workbookId=" + workbookId +
                ", subjectId=" + subjectId +
                ", workbookTitle='" + workbookTitle + '\'' +
                ", workbookDetail='" + workbookDetail + '\'' +
                ", workbookDate='" + workbookDate + '\'' +
                ", workbookDeadline='" + workbookDeadline + '\'' +
                ", workbookQuota=" + workbookQuota +
                '}';
    }
}
