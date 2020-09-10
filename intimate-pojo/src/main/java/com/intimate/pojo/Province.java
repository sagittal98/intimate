package com.intimate.pojo;

import java.io.Serializable;

public class Province implements Serializable {
    private Byte provinceId;

    private Byte provinceCode;

    private String provinceName;

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

    @Override
    public String toString() {
        return "Province{" +
                "provinceId=" + provinceId +
                ", provinceCode=" + provinceCode +
                ", provinceName='" + provinceName + '\'' +
                '}';
    }
}