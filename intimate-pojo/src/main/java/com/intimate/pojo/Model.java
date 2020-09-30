package com.intimate.pojo;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;

public class Model implements Serializable {
    private Long modelId;

    private String modelTitle;

    private String modelImageUrl;

    private Byte modelLevel;

    private Byte modelType;

    @Override
    public String toString() {
        return "{\"modelId\": \"" +
                modelId +
                "\",\"modelTitle\": \"" +
                modelTitle +
                "\",\"modelImageUrl\": \"" +
                modelImageUrl +
                "\",\"modelLevel\": \"" +
                modelLevel +
                "\",\"modelType\": \"" +
                modelType +
                "\"}";
    }

    public Model() {
    }

    public Model(JSONObject modelObject) {
        this.modelId = modelObject.getLong("modelId");
        this.modelTitle = modelObject.getString("modelTitle");
        this.modelImageUrl = modelObject.getString("modelImageUrl");
        this.modelLevel = modelObject.getByte("modelLevel");
        this.modelType = modelObject.getByte("modelType");
    }

    private static final long serialVersionUID = 1L;

    public Long getModelId() {
        return modelId;
    }

    public void setModelId(Long modelId) {
        this.modelId = modelId;
    }

    public String getModelTitle() {
        return modelTitle;
    }

    public void setModelTitle(String modelTitle) {
        this.modelTitle = modelTitle == null ? null : modelTitle.trim();
    }

    public String getModelImageUrl() {
        return modelImageUrl;
    }

    public void setModelImageUrl(String modelImageUrl) {
        this.modelImageUrl = modelImageUrl == null ? null : modelImageUrl.trim();
    }

    public Byte getModelLevel() {
        return modelLevel;
    }

    public void setModelLevel(Byte modelLevel) {
        this.modelLevel = modelLevel;
    }

    public Byte getModelType() {
        return modelType;
    }

    public void setModelType(Byte modelType) {
        this.modelType = modelType;
    }
}