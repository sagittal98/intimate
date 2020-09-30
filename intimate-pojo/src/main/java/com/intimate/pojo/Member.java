package com.intimate.pojo;

import com.alibaba.fastjson.JSONObject;

import javax.xml.crypto.Data;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static java.util.Locale.ENGLISH;

public class Member implements Serializable{
    // 成员id
    private Long memberId;
    // 组织id
    private Long groupId;
    // 用户id
    private Long userId;
    // 用户添加时间
    private Date userCreateData;

    @Override
    public String toString() {
        return "{\"memberId\": \"" +
                memberId +
                "\",\"groupId\": \"" +
                groupId +
                "\",\"userId\": \"" +
                userId +
                "\",\"userCreateData\": \"" +
                userCreateData +
                "\"}";
    }

    public Member() {
    }

    public Member(JSONObject memberObject){
        this.groupId = memberObject.getLong("groupId");
        this.memberId = memberObject.getLong("memberId");
        this.userId = memberObject.getLong("userId");
        Object userCreateData = memberObject.get("userCreateData");
        SimpleDateFormat df = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy",ENGLISH);
        Date date = new Date();
        try {
            date = df.parse(userCreateData.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.userCreateData = date;
    }

    public Member(User user, Long groupId, Date userCreateData) {
        this.groupId = groupId;
        this.userId = user.getUserId();
        this.userCreateData = userCreateData;
    }

    private static final long serialVersionUID = 1L;

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

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

    public Date getUserCreateData() {
        return userCreateData;
    }

    public void setUserCreateData(Date userCreateData) {
        this.userCreateData = userCreateData;
    }



}