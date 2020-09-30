package com.intimate.pojo;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.util.Locale.ENGLISH;

public class Group implements Serializable {
    private Long groupId;

    private Long userId;

    private String groupName;

    private String groupDescription;

    private Date groupCreateDate;

    public Group() {
    }

    public Group(JSONObject groupObject) {
        this.groupId = groupObject.getLong("groupId");
        this.userId = groupObject.getLong("userId");
        this.groupName = groupObject.getString("groupName");
        this.groupDescription = groupObject.getString("groupDescription");
        Object groupCreateDate = groupObject.get("groupCreateDate");
        SimpleDateFormat df = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy",ENGLISH);
        Date date = new Date();
        try {
            date = df.parse(groupCreateDate.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.groupCreateDate = date;
    }

    @Override
    public String toString() {
        return "{\"groupId\": \"" +
                groupId +
                "\",\"userId\": \"" +
                userId +
                "\",\"groupName\": \"" +
                groupName +
                "\",\"groupDescription\": \"" +
                groupDescription +
                "\",\"groupCreateDate\": \"" +
                groupCreateDate +
                "\"}";
    }

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