package com.intimate.pojo;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;

public class Reply implements Serializable {
    private Long replyId;

    private Long noticeId;

    private Long userId;

    private String replyText;

    private String answerUrl;

    @Override
    public String toString() {
        return "{\"replyId\": \"" +
                replyId +
                "\",\"noticeId\": \"" +
                noticeId +
                "\",\"userId\": \"" +
                userId +
                "\",\"replyText\": \"" +
                replyText +
                "\",\"answerUrl\": \"" +
                answerUrl +
                "\"}";
    }

    public Reply() {
    }

    public Reply(JSONObject replyObject) {
        this.replyId = replyObject.getLong("replyId");
        this.noticeId = replyObject.getLong("noticeId");
        this.userId = replyObject.getLong("userId");
        this.replyText = replyObject.getString("replyText");
        this.answerUrl = replyObject.getString("answerUrl");
    }

    private static final long serialVersionUID = 1L;

    public Long getReplyId() {
        return replyId;
    }

    public void setReplyId(Long replyId) {
        this.replyId = replyId;
    }

    public Long getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(Long noticeId) {
        this.noticeId = noticeId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getReplyText() {
        return replyText;
    }

    public void setReplyText(String replyText) {
        this.replyText = replyText == null ? null : replyText.trim();
    }

    public String getAnswerUrl() {
        return answerUrl;
    }

    public void setAnswerUrl(String answerUrl) {
        this.answerUrl = answerUrl == null ? null : answerUrl.trim();
    }
}