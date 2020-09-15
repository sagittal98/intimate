package com.intimate.pojo;

import java.io.Serializable;
import java.util.Date;

public class Group implements Serializable {
    private Long groupId;

    private Long userId;

    private String groupName;

    private String groupDescription;

    private Date groupCreateDate;

    private static final long serialVersionUID = 1L;

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
    }

    public String getGroupDescription() {
        return groupDescription;
    }

    public void setGroupDescription(String groupDescription) {
        this.groupDescription = groupDescription == null ? null : groupDescription.trim();
    }

    public Date getGroupCreateDate() {
        return groupCreateDate;
    }

    public void setGroupCreateDate(Date groupCreateDate) {
        this.groupCreateDate = groupCreateDate;
    }
}