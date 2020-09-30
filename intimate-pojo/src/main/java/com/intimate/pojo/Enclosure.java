package com.intimate.pojo;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;

public class Enclosure implements Serializable {
    private Long enclosureId;

    private Long noticeId;

    private String enclosureUrl;

    private Integer downloadTimes;

    @Override
    public String toString() {
        return "{\"enclosureId\": \"" +
                enclosureId +
                "\",\"noticeId\": \"" +
                noticeId +
                "\",\"enclosureUrl\": \"" +
                enclosureUrl +
                "\",\"downloadTimes\": \"" +
                downloadTimes +
                "\"}";
    }

    public Enclosure() {
    }

    public Enclosure(JSONObject enclosureObject) {
        this.enclosureId = enclosureObject.getLong("enclosureId");
        this.noticeId = enclosureObject.getLong("noticeId");
        this.enclosureUrl = enclosureObject.getString("enclosureUrl");
        this.downloadTimes = enclosureObject.getInteger("downloadTimes");
    }

    private static final long serialVersionUID = 1L;

    public Long getEnclosureId() {
        return enclosureId;
    }

    public void setEnclosureId(Long enclosureId) {
        this.enclosureId = enclosureId;
    }

    public Long getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(Long noticeId) {
        this.noticeId = noticeId;
    }

    public String getEnclosureUrl() {
        return enclosureUrl;
    }

    public void setEnclosureUrl(String enclosureUrl) {
        this.enclosureUrl = enclosureUrl == null ? null : enclosureUrl.trim();
    }

    public Integer getDownloadTimes() {
        return downloadTimes;
    }

    public void setDownloadTimes(Integer downloadTimes) {
        this.downloadTimes = downloadTimes;
    }
}