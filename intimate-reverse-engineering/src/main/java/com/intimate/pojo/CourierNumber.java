package com.intimate.pojo;

import java.io.Serializable;

public class CourierNumber implements Serializable {
    private Long cnId;

    private String cnNumber;

    private Long userId;

    private Long noticeId;

    private static final long serialVersionUID = 1L;

    public Long getCnId() {
        return cnId;
    }

    public void setCnId(Long cnId) {
        this.cnId = cnId;
    }

    public String getCnNumber() {
        return cnNumber;
    }

    public void setCnNumber(String cnNumber) {
        this.cnNumber = cnNumber == null ? null : cnNumber.trim();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(Long noticeId) {
        this.noticeId = noticeId;
    }
}