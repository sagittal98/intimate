package com.intimate.common.model;


import com.intimate.common.enums.ResultStateEnum;

import java.io.Serializable;

/**
 * 封装json对象，所有返回结果都使用它
 */
public class Result<T> implements Serializable {
    // 是否成功标志
    private boolean success;
    // 成功时返回的数据
    private T data;
    // 错误信息
    private String error;
    private static final long serialVersionUID = 1L;
    public Result() {
    }

    // 成功时的构造器
    public Result(boolean success, T data) {
        this.success = success;
        this.data = data;
    }


    // 成功时
    public static <T> Result<T> success(T data,Integer code){
        return new Result<T>(data,code);
    }
    private Result(T data,Integer code) {
        this.success = true;
        this.data = data;
        this.error = ResultStateEnum.stateInfo(code);
    }

    // 失败时
    public static <T> Result<T> error(Integer code){
        return new Result<T>(code);
    }
    // 私有构造方法 不允许外部new
    private Result (Integer code){
        this.success = false;
        this.error = ResultStateEnum.stateInfo(code);
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "Result{" +
                "success=" + success +
                ", data=" + data +
                ", error='" + error + '\'' +
                '}';
    }
}
