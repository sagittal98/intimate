package com.intimate.common.model;

public class SMSInfoModel {
    // 电话
    private String phone;
    // 验证码
    private String code;
    // 有效期
    private String minute;
    // 类型   注册/登录/通知  20876/24405/30693
    private Integer type;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMinute() {
        return minute;
    }

    public void setMinute(String minute) {
        this.minute = minute;
    }
}
