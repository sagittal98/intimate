package com.intimate.common.authorization;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public interface IWeChatAuthorization {
    // 1. 获取微信openid
    JSONObject getOpenidInfo(String js_code) throws Exception;
    // 2. 获取微信用户信息
    JSONObject getWeChatUserInfo(String encryptedData, String session_key, String iv);
}
