package com.intimate.common.authorization;


import com.alibaba.dubbo.common.json.JSONObject;
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
public class WeChatAuthorizationUtils {

//    public static JSONObject doGetJson(String url) throws ClientProtocolException, IOException {
//        JSONObject jsonObject = null;
//        DefaultHttpClient client = new DefaultHttpClient();
//        HttpGet httpGet = new HttpGet(url);
//        HttpResponse response = client.execute(httpGet);
//        HttpEntity entity = response.getEntity();
//        if (entity != null) {
//            String result = EntityUtils.toString(entity, "UTF-8");
//            jsonObject = JSONObject.fromObject(result);
//        }
//        httpGet.releaseConnection();
//        return jsonObject;
//    }

}
