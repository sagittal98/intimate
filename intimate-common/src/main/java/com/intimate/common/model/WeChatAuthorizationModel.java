package com.intimate.common.model;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;


/**
 * 微信获取授权信息
 */
public class WeChatAuthorizationModel implements Serializable {

    // openid
    private String openid;
    // unionId
    private String unionId;
    // 昵称
    private String nickName;
    // 性别
    private Integer gender;
    // 语言
    private String language;
    // 国家
    private String city;
    // 省份
    private String province;
    // 城市
    private String country;
    // 头像url
    private String avatarUrl;
    // 时间戳
    private String timesTamp;

    public WeChatAuthorizationModel() {
    }

    public WeChatAuthorizationModel(JSONObject weChatUserInfo) {
        this.avatarUrl = weChatUserInfo.getString("avatarUrl");
        this.city = weChatUserInfo.getString("city");
        this.province = weChatUserInfo.getString("province");
        this.country = weChatUserInfo.getString("country");
        this.openid = weChatUserInfo.getString("openId");
        this.nickName = weChatUserInfo.getString("nickName");
        this.language = weChatUserInfo.getString("language");
        this.gender = weChatUserInfo.getInteger("gender");
        this.timesTamp = weChatUserInfo.getJSONObject("watermark").getString("timestamp");
    }

    public String getOpenId() {
        return openid;
    }

    public void setOpenId(String openid) {
        this.openid = openid;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getTimesTamp() {
        return timesTamp;
    }

    public void setTimesTamp(String timesTamp) {
        this.timesTamp = timesTamp;
    }

    @Override
    public String toString() {
        return "WeChatAuthorizationModel{" +
                "openid='" + openid + '\'' +
                ", unionId='" + unionId + '\'' +
                ", nickName='" + nickName + '\'' +
                ", gender=" + gender +
                ", language='" + language + '\'' +
                ", city='" + city + '\'' +
                ", province='" + province + '\'' +
                ", country='" + country + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", timesTamp='" + timesTamp + '\'' +
                '}';
    }
}
