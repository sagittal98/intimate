package com.intimate.pojo;

import java.io.Serializable;
import java.util.Date;

public class Notice implements Serializable {
    private Long noticeId;

    private String noticeTitle;

    private String noticeText;

    private String noticeLink;

    private Byte noticeState;

    private Date noticeCreateDate;

    private Date noticeEndDate;

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
}