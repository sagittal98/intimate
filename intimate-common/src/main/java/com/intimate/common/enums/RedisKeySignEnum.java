package com.intimate.common.enums;

import org.springframework.data.redis.connection.RedisClusterConfiguration;
import sun.awt.SunHints;

public enum RedisKeySignEnum {

    // redis缓存 已注册用户前置标记 REGISTER：
    REDIS_REGISTER_ROOT_HEAD(1001,"REGISTER:"),
    // redis 缓存  用户信息  标记 USER-id
    REDIS_SAVE_USER(1002,"USER-"),
    // redis 缓存  成员信息 标记 MEMBER-id
    REDIS_SAVE_MEMBER(1003,"MEMBER-")

    ;

    private int signCode;
    private String sign;

    RedisKeySignEnum(int signCode,String sign){
        this.sign = sign;
        this.signCode = signCode;
    }

    public int getSignCode() {
        return signCode;
    }

    public void setSignCode(int signCode) {
        this.signCode = signCode;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public static String signInfo(int code){
        for (RedisKeySignEnum signEnum: values()){
            if (signEnum.signCode == code){
                return signEnum.sign;
            }
        }
        return null;
    }
}
