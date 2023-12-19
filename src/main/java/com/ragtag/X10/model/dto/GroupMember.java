package com.ragtag.X10.model.dto;

public class GroupMember {

    private String userId;
    private int groupId;
    private boolean isOnline;

    public GroupMember() {
    }

    public GroupMember(String userId, int groupId, boolean isOnline) {
        this.userId = userId;
        this.groupId = groupId;
        this.isOnline = isOnline;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }

    @Override
    public String toString() {
        return "GroupMember{" +
                "userId='" + userId + '\'' +
                ", groupId=" + groupId +
                ", isOnline=" + isOnline +
                '}';
    }
}
