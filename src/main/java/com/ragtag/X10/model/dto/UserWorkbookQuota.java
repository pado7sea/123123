package com.ragtag.X10.model.dto;

public class UserWorkbookQuota {

    private String userId;

    private int workbookId;

    private boolean isSubmit;

    public UserWorkbookQuota() {
    }

    public UserWorkbookQuota(String userId, int workbookId, boolean isSubmit) {
        this.userId = userId;
        this.workbookId = workbookId;
        this.isSubmit = isSubmit;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getWorkbookId() {
        return workbookId;
    }

    public void setWorkbookId(int workbookId) {
        this.workbookId = workbookId;
    }

    public boolean isSubmit() {
        return isSubmit;
    }

    public void setSubmit(boolean submit) {
        isSubmit = submit;
    }

    @Override
    public String toString() {
        return "UserWorkbookQuota{" +
                "userId='" + userId + '\'' +
                ", workbookId=" + workbookId +
                ", isSubmit=" + isSubmit +
                '}';
    }
}
