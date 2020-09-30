package com.intimate.pojo;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;

public class City implements Serializable {
    private Short cityId;

    private Short cityCode;

    private String cityName;

    @Override
    public String toString() {
        return "{\"cityId\": \"" +
                cityId +
                "\",\"cityCode\": \"" +
                cityCode +
                "\",\"cityName\": \"" +
                cityName +
                "\"}";
    }

    public City() {
    }

    public City(JSONObject cityObject) {
        this.cityId = cityObject.getShort("cityId");
        this.cityCode = cityObject.getShort("cityCode");
        this.cityName = cityObject.getString("cityName");
    }

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