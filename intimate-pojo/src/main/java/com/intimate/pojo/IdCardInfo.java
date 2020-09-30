package com.intimate.pojo;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;

public class IdCardInfo implements Serializable {
    private Long idCardInfoId;

    private Long idCardNumber;

    private String idCardName;

    private Long userId;

    private String idCardImagePositive;

    private String idCardImageVerso;


    public IdCardInfo() {
    }

    public IdCardInfo(JSONObject idCardInfoObject) {
        this.idCardInfoId = idCardInfoObject.getLong("idCardInfoId");
        this.idCardNumber = idCardInfoObject.getLong("idCardNumber");
        this.idCardName =  idCardInfoObject.getString("idCardName");
        this.userId = idCardInfoObject.getLong("userId");
        this.idCardImagePositive = idCardInfoObject.getString("idCardImagePositive");
        this.idCardImageVerso = idCardInfoObject.getString("idCardImageVerso");
    }

    @Override
    public String toString() {
        return "{\"idCardInfoId\": \"" +
                idCardInfoId +
                "\",\"idCardNumber\": \"" +
                idCardNumber +
                "\",\"idCardName\": \"" +
                idCardName +
                "\",\"userId\": \"" +
                userId +
                "\",\"idCardImagePositive\": \"" +
                idCardImagePositive +
                "\",\"idCardImageVerso\": \"" +
                idCardImageVerso +
                "\"}";
    }


    private static final long serialVersionUID = 1L;

    public Long getIdCardInfoId() {
        return idCardInfoId;
    }

    public void setIdCardInfoId(Long idCardInfoId) {
        this.idCardInfoId = idCardInfoId;
    }

    public Long getIdCardNumber() {
        return idCardNumber;
    }

    public void setIdCardNumber(Long idCardNumber) {
        this.idCardNumber = idCardNumber;
    }

    public String getIdCardName() {
        return idCardName;
    }

    public void setIdCardName(String idCardName) {
        this.idCardName = idCardName == null ? null : idCardName.trim();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getIdCardImagePositive() {
        return idCardImagePositive;
    }

    public void setIdCardImagePositive(String idCardImagePositive) {
        this.idCardImagePositive = idCardImagePositive == null ? null : idCardImagePositive.trim();
    }

    public String getIdCardImageVerso() {
        return idCardImageVerso;
    }

    public void setIdCardImageVerso(String idCardImageVerso) {
        this.idCardImageVerso = idCardImageVerso == null ? null : idCardImageVerso.trim();
    }
}