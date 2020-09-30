package com.intimate.pojo;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.util.Locale.ENGLISH;

public class Note implements Serializable {
    private Long noteId;

    private String noteTitle;

    private String noteText;

    private Long userId;

    private Long modelId;

    private Boolean isCardModel;

    private Date noteCreateTime;

    private Date noteStartTime;

    @Override
    public String toString() {
        return "{\"noteId\": \"" +
                noteId +
                "\",\"noteTitle\": \"" +
                noteTitle +
                "\",\"noteText\": \"" +
                noteText +
                "\",\"userId\": \"" +
                userId +
                "\",\"modelId\": \"" +
                modelId +
                "\",\"isCardModel\": \"" +
                isCardModel +
                "\",\"noteCreateTime\": \"" +
                noteCreateTime +
                "\",\"noteStartTime\": \"" +
                noteStartTime +
                "\"}";
    }

    public Note(JSONObject noteObject) {
        this.noteId = noteObject.getLong("noteId");
        this.noteTitle = noteObject.getString("noteTitle");
        this.noteText = noteObject.getString("noteText");
        this.userId = noteObject.getLong("userId");
        this.modelId = noteObject.getLong("modelId");
        this.isCardModel = noteObject.getBoolean("isCardModel");
        Object noteCreateTime = noteObject.get("noteCreateTime");
        Object noteStartTime = noteObject.get("noteStartTime");
        SimpleDateFormat df = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy",ENGLISH);
        try {
            this.noteCreateTime = df.parse(noteCreateTime.toString());
            this.noteStartTime = df.parse(noteStartTime.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

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