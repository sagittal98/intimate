package com.intimate.pojo;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.util.Locale.ENGLISH;

public class Notice implements Serializable {
    private Long noticeId;

    private String noticeTitle;

    private String noticeText;

    private String noticeLink;

    private Byte noticeState;

    private Date noticeCreateDate;

    private Date noticeEndDate;

    private Long groupId;

    @Override
    public String toString() {
        return "{\"noticeId\": \"" +
                noticeId +
                "\",\"noticeTitle\": \"" +
                noticeTitle +
                "\",\"noticeText\": \"" +
                noticeText +
                "\",\"noticeLink\": \"" +
                noticeLink +
                "\",\"noticeState\": \"" +
                noticeState +
                "\",\"noticeCreateDate\": \"" +
                noticeCreateDate +
                "\",\"noticeEndDate\": \"" +
                noticeEndDate +
                "\",\"groupId\": \"" +
                groupId +
                "\"}";
    }

    public Notice() {
    }

    public Notice(JSONObject noticeObject) {
        this.noticeId = noticeObject.getLong("noticeId");
        this.noticeTitle = noticeObject.getString("noticeTitle");
        this.noticeText = noticeObject.getString("noticeText");
        this.noticeLink = noticeObject.getString("noticeLink");
        this.noticeState = noticeObject.getByte("noticeState");

        Object noticeCreateDate = noticeObject.get("noticeCreateDate");
        Object noticeEndDate = noticeObject.get("noticeEndDate");
        SimpleDateFormat df = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy",ENGLISH);
        try {
            this.noticeCreateDate =df.parse(noticeCreateDate.toString());
            this.noticeEndDate = df.parse(noticeEndDate.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        this.groupId = noticeObject.getLong("groupId");
    }

    private static final long serialVersionUID = 1L;

    public Long getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(Long noticeId) {
        this.noticeId = noticeId;
    }

    public String getNoticeTitle() {
        return noticeTitle;
    }

    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle == null ? null : noticeTitle.trim();
    }

    public String getNoticeText() {
        return noticeText;
    }

    public void setNoticeText(String noticeText) {
        this.noticeText = noticeText == null ? null : noticeText.trim();
    }

    public String getNoticeLink() {
        return noticeLink;
    }

    public void setNoticeLink(String noticeLink) {
        this.noticeLink = noticeLink == null ? null : noticeLink.trim();
    }

    public Byte getNoticeState() {
        return noticeState;
    }

    public void setNoticeState(Byte noticeState) {
        this.noticeState = noticeState;
    }

    public Date getNoticeCreateDate() {
        return noticeCreateDate;
    }

    public void setNoticeCreateDate(Date noticeCreateDate) {
        this.noticeCreateDate = noticeCreateDate;
    }

    public Date getNoticeEndDate() {
        return noticeEndDate;
    }

    public void setNoticeEndDate(Date noticeEndDate) {
        this.noticeEndDate = noticeEndDate;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }
}