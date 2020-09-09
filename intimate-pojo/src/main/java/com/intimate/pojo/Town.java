package com.intimate.pojo;

import java.io.Serializable;

public class Town implements Serializable {
    private Short townId;

    private Integer townCode;

    private String townName;

    private static final long serialVersionUID = 1L;

    public Short getTownId() {
        return townId;
    }

    public void setTownId(Short townId) {
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