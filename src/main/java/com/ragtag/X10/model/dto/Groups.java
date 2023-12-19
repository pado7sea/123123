package com.ragtag.X10.model.dto;

public class Groups {
    private int groupId;
    private String groupLeaderId;
    private String groupName;
    private String groupDetail;
    private String groupImg;

    public Groups() {
    }

    public Groups(int groupId, String groupLeaderId, String groupName, String groupDetail, String groupImg) {
        this.groupId = groupId;
        this.groupLeaderId = groupLeaderId;
        this.groupName = groupName;
        this.groupDetail = groupDetail;
        this.groupImg = groupImg;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getGroupLeaderId() {
        return groupLeaderId;
    }

    public void setGroupLeaderId(String groupLeaderId) {
        this.groupLeaderId = groupLeaderId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupDetail() {
        return groupDetail;
    }

    public void setGroupDetail(String groupDetail) {
        this.groupDetail = groupDetail;
    }

    public String getGroupImg() {
        return groupImg;
    }

    public void setGroupImg(String groupImg) {
        this.groupImg = groupImg;
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupId=" + groupId +
                ", groupLeaderId='" + groupLeaderId + '\'' +
                ", groupName='" + groupName + '\'' +
                ", groupDetail='" + groupDetail + '\'' +
                ", groupImg='" + groupImg + '\'' +
                '}';
    }
}
