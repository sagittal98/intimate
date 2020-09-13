package com.intimate.common.model;

import com.intimate.common.enums.ExceptionEnum;

import java.io.Serializable;

// 异常模板
public class ExceptionModel implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer code;
    private String msg;
    private Long timestamp;

    public Integer getCode() {
        return code;
    }


    public String getMsg() {
        return msg;
    }


    public Long getTimestamp() {
        return timestamp;
    }

    public ExceptionModel(ExceptionEnum exceptionEnum) {
        this.code = exceptionEnum.getCode();
        this.msg = exceptionEnum.getMsg();
        this.timestamp = System.currentTimeMillis();
    }
}
