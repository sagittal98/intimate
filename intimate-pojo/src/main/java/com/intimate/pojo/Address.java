package com.intimate.pojo;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;

public class Address implements Serializable {
    private Long addressId;

    private Long userId;

    private Integer addressCode;

    private String addressSpecific;

    @Override
    public String toString() {
        return "{\"addressId\": \"" +
                addressId +
                "\",\"userId\": \"" +
                userId +
                "\",\"addressCode\": \"" +
                addressCode +
                "\",\"addressSpecific\": \"" +
                addressSpecific +
                "\"}";
    }

    public Address() {
    }

    public Address(JSONObject addressObject) {
        this.addressId = addressObject.getLong("addressId");
        this.userId = addressObject.getLong("userId");
        this.addressCode = addressObject.getInteger("addressCode");
        this.addressSpecific = addressObject.getString("addressSpecific");
    }

    private static final long serialVersionUID = 1L;

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getAddressCode() {
        return addressCode;
    }

    public void setAddressCode(Integer addressCode) {
        this.addressCode = addressCode;
    }

    public String getAddressSpecific() {
        return addressSpecific;
    }

    public void setAddressSpecific(String addressSpecific) {
        this.addressSpecific = addressSpecific == null ? null : addressSpecific.trim();
    }
}