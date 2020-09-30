package com.intimate.pojo;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;

public class Province implements Serializable {
    private Byte provinceId;

    private Byte provinceCode;

    private String provinceName;

    @Override
    public String toString() {
        return "{\"provinceId\": \"" +
                provinceId +
                "\",\"provinceCode\": \"" +
                provinceCode +
                "\",\"provinceName\": \"" +
                provinceName +
                "\"}";
    }

    public Province(JSONObject provinceObject) {
        this.provinceId = provinceObject.getByte("provinceId");
        this.provinceCode = provinceObject.getByte("provinceCode");
        this.provinceName = provinceObject.getString("provinceName");
    }

    private static final long serialVersionUID = 1L;

    public Byte getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Byte provinceId) {
        this.provinceId = provinceId;
    }

    public Byte getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(Byte provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName == null ? null : provinceName.trim();
    }

}