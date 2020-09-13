package com.intimate.common.exception;


import com.intimate.common.enums.ExceptionEnum;

/**
 * 自定义异常
 */
public class MyException extends RuntimeException {

    // 异常枚举
    private ExceptionEnum exceptionEnum;

    public MyException(ExceptionEnum exceptionEnum) {
        this.exceptionEnum = exceptionEnum;
    }

    public ExceptionEnum getExceptionEnum() {
        return exceptionEnum;
    }

}
