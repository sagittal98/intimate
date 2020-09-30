package com.intimate.pojo;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;

public class Country implements Serializable {
    private Short countryId;

    private Integer countryCode;

    private String countryName;

    @Override
    public String toString() {
        return "{\"countryId\": \"" +
                countryId +
                "\",\"countryCode\": \"" +
                countryCode +
                "\",\"countryName\": \"" +
                countryName +
                "\"}";
    }

    public Country() {
    }

    public Country(JSONObject countryObject) {
        this.countryId = countryObject.getShort("countryId");
        this.countryCode = countryObject.getInteger("countryCode");
        this.countryName = countryObject.getString("countryName");
    }

    private static final long serialVersionUID = 1L;

    public Short getCountryId() {
        return countryId;
    }

    public void setCountryId(Short countryId) {
        this.countryId = countryId;
    }

    public Integer getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(Integer countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName == null ? null : countryName.trim();
    }
}