package com.intimate.common.model;

import io.jsonwebtoken.Claims;

import java.io.Serializable;

public class CheckResult implements Serializable {
    private static final long serialVersionUID = 1L;
    // 是否成功
    private boolean success;
    // 解析结果
    private Claims claims;
    // 错误信息
    private Integer errCode;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Claims getClaims() {
        return claims;
    }

    public void setClaims(Claims claims) {
        this.claims = claims;
    }

    public Integer getErrCode() {
        return errCode;
    }

    public void setErrCode(Integer errCode) {
        this.errCode = errCode;
    }

    @Override
    public String toString() {
        return "CheckResult{" +
                "success=" + success +
                ", claims=" + claims +
                ", errCode=" + errCode +
                '}';
    }
}
