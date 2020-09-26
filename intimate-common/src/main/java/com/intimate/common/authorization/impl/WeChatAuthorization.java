package com.intimate.common.authorization.impl;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.intimate.common.authorization.IWeChatAuthorization;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.InvalidParameterSpecException;
import java.util.Arrays;

/**
 * 微信网络请求工具
 */
public class WeChatAuthorization implements IWeChatAuthorization {

    private final static String APP_ID = "?appid=wxbbd28fed386988fc";
    private final static String SECRET = "&secret=43c56d52b03d74300403d9840b3f0e8d";
    private final static String GRANT_TYPE = "&grant_type=authorization_code";

    @Override
    public JSONObject getOpenidInfo(String js_code) throws Exception {
        String requestUrl = "https://api.weixin.qq.com/sns/jscode2session" + APP_ID + SECRET + "&js_code=" + js_code + GRANT_TYPE;
        String openInfo = (new WeChatHttpRequest()).doGet(requestUrl);
        System.out.println(openInfo);
        return JSONObject.parseObject(openInfo);
    }

    @Override
    public JSONObject getWeChatUserInfo(String encryptedData, String session_key, String iv) {
        byte[] dataByte = Base64.decode(encryptedData);
        byte[] keyByte = Base64.decode(session_key);
        byte[] ivByte = Base64.decode(iv);
        try {
            int base = 16;
            if (keyByte.length % base != 0) {
                int groups = keyByte.length / base + (keyByte.length % base != 0 ? 1 : 0);
                byte[] temp = new byte[groups * base];
                Arrays.fill(temp, (byte)0);
                System.arraycopy(keyByte, 0, temp, 0, keyByte.length);
                keyByte = temp;
            }

            Security.addProvider(new BouncyCastleProvider());
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding", "BC");
            SecretKeySpec spec = new SecretKeySpec(keyByte, "AES");
            AlgorithmParameters parameters = AlgorithmParameters.getInstance("AES");
            parameters.init(new IvParameterSpec(ivByte));
            cipher.init(2, spec, parameters);
            byte[] resultByte = cipher.doFinal(dataByte);
            if (null != resultByte && resultByte.length > 0) {
                String result = new String(resultByte, StandardCharsets.UTF_8);
                return JSONObject.parseObject(result);
            }
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidParameterSpecException | IllegalBlockSizeException | BadPaddingException | InvalidKeyException | InvalidAlgorithmParameterException | NoSuchProviderException var13) {
            var13.printStackTrace();
        }
        return null;
    }


    // todo 微信授权逻辑实现





}
