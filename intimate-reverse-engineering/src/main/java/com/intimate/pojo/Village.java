package com.intimate.pojo;

import java.io.Serializable;

public class Village implements Serializable {
    private Integer villageId;

    private Long villageCode;

    private Short villageType;

    private String villageName;

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