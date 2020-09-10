package com.intimate.pojo;

import java.io.Serializable;
import java.util.Date;

public class Note implements Serializable {
    private Long noteId;

    private String noteTitle;

    private String noteText;

    private Long userId;

    private Long modelId;

    private Boolean isCardModel;

    private Date noteCreateTime;

    private Date noteStartTime;

    private static final long serialVersionUID = 1L;

    public Long getNoteId() {
        return noteId;
    }

    public void setNoteId(Long noteId) {
        this.noteId = noteId;
    }

    public String getNoteTitle() {
        return noteTitle;
    }

    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle == null ? null : noteTitle.trim();
    }

    public String getNoteText() {
        return noteText;
    }

    public void setNoteText(String noteText) {
        this.noteText = noteText == null ? null : noteText.trim();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getModelId() {
        return modelId;
    }

    public void setModelId(Long modelId) {
        this.modelId = modelId;
    }

    public Boolean getIsCardModel() {
        return isCardModel;
    }

    public void setIsCardModel(Boolean isCardModel) {
        this.isCardModel = isCardModel;
    }

    public Date getNoteCreateTime() {
        return noteCreateTime;
    }

    public void setNoteCreateTime(Date noteCreateTime) {
        this.noteCreateTime = noteCreateTime;
    }

    public Date getNoteStartTime() {
        return noteStartTime;
    }

    public void setNoteStartTime(Date noteStartTime) {
        this.noteStartTime = noteStartTime;
    }
}