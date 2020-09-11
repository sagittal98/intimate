package com.intimate.common.model;


/**
 * 用户信息
 */
public class UserInfo {
    // 手机
    private String phone;
    // openid
    private String openID;
    // 权限级别
    private String authorityLevel;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOpenID() {
        return openID;
    }

    public void setOpenID(String openID) {
        this.openID = openID;
    }


    public String getAuthorityLevel() {
        return authorityLevel;
    }

    public void setAuthorityLevel(String authorityLevel) {
        this.authorityLevel = authorityLevel;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "phone='" + phone + '\'' +
                ", openID='" + openID + '\'' +
                ", authorityLevel='" + authorityLevel + '\'' +
                '}';
    }
}
