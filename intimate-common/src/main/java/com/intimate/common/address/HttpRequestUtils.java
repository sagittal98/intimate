package com.intimate.common.address;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 *  network request tools 网络请求工具
 */
class HttpRequestUtils {

    // 100KB
    private static final int BYTE_LEN = 102400;
    // base code format. 基础编码格式
    private static final String BASE_CHAR_SET = "UTF-8";
    private static  String ID_CARD_CHAR_SET = "GBK";

    /**
     * get request. get请求
     */
    private String sendGetModel(String url, String charset){
        StringBuilder result = new StringBuilder();
        BufferedReader in = null;
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的链接
            URLConnection connection = realUrl.openConnection();
            // 设置通用请求的属性
            connection.setRequestProperty("accept","*/*");
            connection.setRequestProperty("connection","keep-Alive");
            connection.setRequestProperty("user-agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立连接超时时间
            connection.setConnectTimeout(1000);
            // 建立传递数据超时时间
            connection.setReadTimeout(1000);
            // 建立实际的链接
            connection.connect();
            // 定义bufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(connection.getInputStream(),charset));
            String line;
            while ((line = in.readLine()) != null){
                result.append(line);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("链接失败！... 重新连接中...");
            System.out.println(url);
            System.out.println(charset);
            // 重新连接
            sendGetModel(url,charset);
        }finally {
            try {
                if (in!=null){
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result.toString();
    }

    /**
     * 地址查询
     */
    String address(String url){
        return  sendGetModel(url, ID_CARD_CHAR_SET);
    }
}
