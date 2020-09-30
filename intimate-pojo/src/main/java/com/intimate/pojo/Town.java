package com.intimate.pojo;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;

public class Town implements Serializable {
    private Integer townId;

    private Integer townCode;

    private String townName;

    @Override
    public String toString() {
        return "{\"townId\": \"" +
                townId +
                "\",\"townCode\": \"" +
                townCode +
                "\",\"townName\": \"" +
                townName +
                "\"}";
    }

    public Town() {
    }

    public Town(JSONObject townObject) {
        this.townId = townObject.getInteger("townId");
        this.townCode = townObject.getInteger("townCode");
        this.townName = townObject.getString("townName");
    }

    private static final long serialVersionUID = 1L;

    public Integer getTownId() {
        return townId;
    }

    public void setTownId(Integer townId) {
        this.townId = townId;
    }

    public Integer getTownCode() {
        return townCode;
    }

    public void setTownCode(Integer townCode) {
        this.townCode = townCode;
    }

    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName == null ? null : townName.trim();
    }

}