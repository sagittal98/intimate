package com.intimate.common.token;

import com.intimate.common.model.CheckResult;

import java.util.Date;

public class Test {


    public static void main(String[] args) {
        // jti jwt的唯一身份标识，主要用来作为一次性token,从而回避重放攻击
        // 标识：为服务器标识。
        String jti = "login";
        // jwt所面向的用户  数据
        String sub = "{'password':'hello','username':'root'}";
        // iss 签发者
        // iat: jwt的签发时间
        // exp: jwt的过期时间，这个过期时间必须要大于签发时间
//        long ttlMillis =  6 * 30 * 24 * 60 * 60 * 1000L;
        long ttlMillis =  1000L;
        String jwt = JwtUtils.createJWT(jti, sub, ttlMillis);
        System.out.println(jwt);
        CheckResult checkResult = JwtUtils.validateJWT(jwt);
        System.out.println(checkResult.toString());



    }
}
