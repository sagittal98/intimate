package com.intimate.common.model;

import java.io.Serializable;
import java.sql.Date;

/**
 * 身份证模板
 */
public class IDCardInfoModel implements Serializable {
    // 身份证号
    private String IDNumber;
    // 身份证姓名
    private String IDName;
    // 身份证出生年月日
    private String IDBirth;
    // 身份证性别
    private Integer IDSex;
    // 身份证年龄
    private Integer IDAge;
    // 身份证地址编号
    private Integer IDAddressCode;

    private static final long serialVersionUID = 1L;

    public String getIDNumber() {
        return IDNumber;
    }

    public void setIDNumber(String IDNumber) {
        this.IDNumber = IDNumber;
    }

    public String getIDName() {
        return IDName;
    }

    public void setIDName(String IDName) {
        this.IDName = IDName;
    }

    public String getIDBirth() {
        return IDBirth;
    }

    public void setIDBirth(String IDBirth) {
        this.IDBirth = IDBirth;
    }

    public Integer getIDSex() {
        return IDSex;
    }

    public void setIDSex(Integer IDSex) {
        this.IDSex = IDSex;
    }

    public Integer getIDAge() {
        return IDAge;
    }

    public void setIDAge(Integer IDAge) {
        this.IDAge = IDAge;
    }

    public Integer getIDAddressCode() {
        return IDAddressCode;
    }

    public void setIDAddressCode(Integer IDAddressCode) {
        this.IDAddressCode = IDAddressCode;
    }


    @Override
    public String toString() {
        return "IDCardInfoModel{" +
                "IDNumber='" + IDNumber + '\'' +
                ", IDName='" + IDName + '\'' +
                ", IDBirth=" + IDBirth +
                ", IDSex=" + IDSex +
                ", IDAge=" + IDAge +
                ", IDAddressCode=" + IDAddressCode +
                '}';
    }
}
