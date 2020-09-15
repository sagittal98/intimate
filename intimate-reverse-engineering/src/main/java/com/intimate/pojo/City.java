package com.intimate.pojo;

import java.io.Serializable;

public class City implements Serializable {
    private Short cityId;

    private Short cityCode;

    private String cityName;

    private static final long serialVersionUID = 1L;

    public Short getCityId() {
        return cityId;
    }

    public void setCityId(Short cityId) {
        this.cityId = cityId;
    }

    public Short getCityCode() {
        return cityCode;
    }

    public void setCityCode(Short cityCode) {
        this.cityCode = cityCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName == null ? null : cityName.trim();
    }
}