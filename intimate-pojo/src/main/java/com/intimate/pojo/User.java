package com.intimate.pojo;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private Long userId;

    private String openid;

    private String nickName;

    private String birth;

    private Short age;

    private Short sex;

    private String phone;

    private String password;

    private Short nativePlaceCode;

    private String authorityLevel;

    private Integer qq;

    private String avatarUrl;

    private Boolean isPhoneCheck;

    private Boolean isQqCheck;

    private Boolean isWeixinCheck;

    private Date registerDate;

    private Date lastLoginTime;

    private static final long serialVersionUID = 1L;

    public User() {
    }

    public User(Long userId,String authorityLevel) {
        this.userId = userId;
        this.authorityLevel = authorityLevel;
    }

    public User(JSONObject objectUserInfo) {
        this.userId = objectUserInfo.getLong("userId");
        this.openid = objectUserInfo.getString("openid");
        this.nickName = objectUserInfo.getString("nickName");
        this.birth = objectUserInfo.getString("birth");
        this.age = objectUserInfo.getShort("age");
        this.sex = objectUserInfo.getShort("sex");
        this.phone = objectUserInfo.getString("phone");
        this.password = objectUserInfo.getString("password");
        this.nativePlaceCode = objectUserInfo.getShort("nativePlaceCode");
        this.authorityLevel = objectUserInfo.getString("authorityLevel");
        this.qq = objectUserInfo.getInteger("qq");
        this.avatarUrl = objectUserInfo.getString("avatarUrl");
        this.isPhoneCheck = objectUserInfo.getBoolean("isPhoneCheck");
        this.isQqCheck = objectUserInfo.getBoolean("isQqCheck");
        this.isWeixinCheck = objectUserInfo.getBoolean("isWeixinCheck");
        this.registerDate = objectUserInfo.getDate("registerDate");
        this.lastLoginTime = objectUserInfo.getDate("lastLoginTime");
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth == null ? null : birth.trim();
    }

    public Short getAge() {
        return age;
    }

    public void setAge(Short age) {
        this.age = age;
    }

    public Short getSex() {
        return sex;
    }

    public void setSex(Short sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Short getNativePlaceCode() {
        return nativePlaceCode;
    }

    public void setNativePlaceCode(Short nativePlaceCode) {
        this.nativePlaceCode = nativePlaceCode;
    }

    public String getAuthorityLevel() {
        return authorityLevel;
    }

    public void setAuthorityLevel(String authorityLevel) {
        this.authorityLevel = authorityLevel == null ? null : authorityLevel.trim();
    }

    public Integer getQq() {
        return qq;
    }

    public void setQq(Integer qq) {
        this.qq = qq;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl == null ? null : avatarUrl.trim();
    }

    public Boolean getIsPhoneCheck() {
        return isPhoneCheck;
    }

    public void setIsPhoneCheck(Boolean isPhoneCheck) {
        this.isPhoneCheck = isPhoneCheck;
    }

    public Boolean getIsQqCheck() {
        return isQqCheck;
    }

    public void setIsQqCheck(Boolean isQqCheck) {
        this.isQqCheck = isQqCheck;
    }

    public Boolean getIsWeixinCheck() {
        return isWeixinCheck;
    }

    public void setIsWeixinCheck(Boolean isWeixinCheck) {
        this.isWeixinCheck = isWeixinCheck;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }
}