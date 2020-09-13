package com.intimate.common.enums;

/**
 * 异常枚举
 */
public enum ExceptionEnum {

    EXCEPTION_SQL_ADD(580,"SQL 添加信息"),
    EXCEPTION_SQL_INSERT(581,"SQL 插入信息")
    ;
    // 状态码
    private Integer code;
    // 异常信息
    private String msg;

    ExceptionEnum(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
