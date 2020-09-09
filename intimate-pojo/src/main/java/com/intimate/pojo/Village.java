package com.intimate.pojo;

import java.io.Serializable;

public class Village implements Serializable {
    private Short villageId;

    private Long villageCode;

    private Byte villageType;

    private String villageName;

    private static final long serialVersionUID = 1L;

    public Short getVillageId() {
        return villageId;
    }

    public void setVillageId(Short villageId) {
        this.villageId = villageId;
    }

    public Long getVillageCode() {
        return villageCode;
    }

    public void setVillageCode(Long villageCode) {
        this.villageCode = villageCode;
    }

    public Byte getVillageType() {
        return villageType;
    }

    public void setVillageType(Byte villageType) {
        this.villageType = villageType;
    }

    public String getVillageName() {
        return villageName;
    }

    public void setVillageName(String villageName) {
        this.villageName = villageName == null ? null : villageName.trim();
    }
}