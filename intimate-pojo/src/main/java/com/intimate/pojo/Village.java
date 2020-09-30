package com.intimate.pojo;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;

public class Village implements Serializable {
    private Integer villageId;

    private Long villageCode;

    private Short villageType;

    private String villageName;

    @Override
    public String toString() {
        return "{\"villageId\": \"" +
                villageId +
                "\",\"villageCode\": \"" +
                villageCode +
                "\",\"villageType\": \"" +
                villageType +
                "\",\"villageName\": \"" +
                villageName +
                "\"}";
    }

    public Village() {
    }

    public Village(JSONObject villageObject) {
        this.villageId = villageObject.getInteger("villageId");
        this.villageCode = villageObject.getLong("villageCode");
        this.villageType = villageObject.getShort("villageType");
        this.villageName = villageObject.getString("villageName");
    }

    private static final long serialVersionUID = 1L;

    public Integer getVillageId() {
        return villageId;
    }

    public void setVillageId(Integer villageId) {
        this.villageId = villageId;
    }

    public Long getVillageCode() {
        return villageCode;
    }

    public void setVillageCode(Long villageCode) {
        this.villageCode = villageCode;
    }

    public Short getVillageType() {
        return villageType;
    }

    public void setVillageType(Short villageType) {
        this.villageType = villageType;
    }

    public String getVillageName() {
        return villageName;
    }

    public void setVillageName(String villageName) {
        this.villageName = villageName == null ? null : villageName.trim();
    }

}