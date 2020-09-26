package com.intimate.common.authorization;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.intimate.common.authorization.impl.WeChatAuthorization;
import com.intimate.common.model.WeChatAuthorizationModel;
import org.junit.Test;

public class TestWeChat {

    private IWeChatAuthorization weChatAuthorization = new WeChatAuthorization();


    @Test
    public void test () throws Exception {

        String js_code  = "0711AHFa1iRYGz00tWGa1w2TTJ11AHF-";
        JSONObject openidInfo = weChatAuthorization.getOpenidInfo(js_code);
        System.out.println(openidInfo.toJSONString());
        String encryptedData = "2uFNmeVF1tNCG7MvdeDoNg+jWO7j0UeVIC6ovKu8BFtmdCAURINPo0z0hZvZkl1wNjXs+7SjFfc0UHMN7PmI5rPTO8qpd3N+tCKq/Ly8nZL8GzGsHjWG/+EI7lF0Xz2UB0Ju0QFcZlpHmX2tTHw31eJgQ/AWZwJr3Yk1tAnWIGwdAhUsrbmKH2irFCp885pROGLfgaLx7E3jHPTnw0M415pypPQVpgVWO5v7WgiYfxzuXUmvzch/gY01XpNkra8uTIrBbpbiU26K2VhfzRZ/6eBvJD7bn/a+9iPB+XTfUs/GTtebNV05yfbDMeHUct41BQ8DlbGuDvvJT9w43SZ1cuhUNLs8T5FY9Fh6BopRRLHhtmqreANqpQNDc5/lDlSw+NT9MyOd/yx3h+GSeK3f7x4J0jsqFEyDjsp9EDNrUYJC4JwLfXof3Me1XDu+Jyn4A8hBas4CF8uy4uaQayZ/LsQrr4mb2hjK3eNTYXqgZSA=";
        String sessionkey = openidInfo.getString("session_key");
        String iv = "/qsYU0MO4aF7KOGrLjs8yw==";
        JSONObject weChatUserInfo = weChatAuthorization.getWeChatUserInfo(encryptedData, sessionkey, iv);
        System.out.println(weChatUserInfo.toJSONString());
        WeChatAuthorizationModel weChatAuthorizationModel = new WeChatAuthorizationModel(weChatUserInfo);
        System.out.println(weChatAuthorizationModel.toString());
    }

}
