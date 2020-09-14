package com.intimate.common.authorization.impl;


import com.alibaba.dubbo.common.json.JSONObject;
import com.intimate.common.authorization.IWeChatAuthorization;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * 微信网络请求工具
 */
public class WeChatAuthorization implements IWeChatAuthorization {

//   GET
//   https://api.weixin.qq.com/sns/jscode2session?
//   appid=APPID&secret=SECRET&js_code=JSCODE
//   &grant_type=authorization_code

    private final static String APP_ID = "";
    private final static String SECRET = "";
    private final static String GRANT_TYPE = "authorization_code";


    // todo 微信授权逻辑实现





}
